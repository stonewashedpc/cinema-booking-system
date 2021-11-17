package relationManagement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import baseTypes.Texts;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import db.executer.PersistenceDMLExecuter;
import db.executer.PersistenceException;
import idManagement.Identifiable;
import utilities.ListUtilities;
/**
 * Represents the elements of a binary relation \subseteq S x T 
 * It is a multi-set to enable lists, e.g., in an association A->^theBList B  
 */
public class Relation<S extends Identifiable,T extends Identifiable> {
/**	
 * Redundant storage of relation: Symmetric, indexed over S, indexed over T
 * Class invariants in consistent states:
 * 		1. For all s\in S: SIndex.get(s) = {t | (s,t) \in R} (as Multi-Set)
 * 		2. For all t\in T: TIndex.get(t) = {s | (s,t) \in R} (as Multi-Set)
 *  	3. For both indices i in {SIndex, TIndex}: For all x: i.containsKey(x) => !(i.get(x).isEmpty())
 *  	4. For all (s,t)\in elements: s != null != t
 *  
 *     Consistent states are before and after 
 *     change
 *     addElement
 *     removeElement
 */
	private List<RelElement<S, T>> elements;
	private Map<S,List<T>> SIndex;
	private Map<T,List<S>> TIndex;
	private String relationname;
	private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
	public Relation(String relationname) {
		this.elements = new ArrayList<>();
		this.SIndex = new HashMap<S,List<T>>();
		this.TIndex = new HashMap<T,List<S>>();
		this.relationname = relationname;
	}
	public List<T> getRelatedTargets(S s){
		if(!this.SIndex.containsKey(s)) return new ArrayList<T>();
		return this.SIndex.get(s);
	}
	public List<S> getRelatedSources(T t){
		if(!this.TIndex.containsKey(t)) return new ArrayList<S>();
		return this.TIndex.get(t);
	}	
 
/**
 * Unchecked and unrestricted addition of a relation element - null references are not added
 * Two versions depending on whether caller knows that the pair is already persistent or not
 */
	public void addElementAlreadyPersistent(S s, T t) {
		if(s==null || t==null) return;
		this.elements.add(new RelElement<S,T>(s, t));
		this.indexAdd(s, t, SIndex);
		this.indexAdd(t, s, TIndex);
		this.invariantCheck();
	}
/**	
 * Adds (s,t) to this relation consistently with the database 
 * REQUIRES s!=null
 * @throws PersistenceException, e.g. if foreign key constraint are violated
 */
	public void addElement(S s, T t) throws PersistenceException{
		if(t==null) return; // No null value possible!
		try {
			this.dmlExecuter.insertInto(relationname, "id, p1, p2", this.dmlExecuter.getNextId().toString() + ", " + s.getId().toString() + ", " + t.getId().toString());
		}catch(SQLException | NoConnectionException e) {
			throw new PersistenceException(e.getMessage());
		}
		this.addElementAlreadyPersistent(s, t);
	}
/**	
 * Sets the new target @param newT for @param s
 * If s was related to @param oldT before, one of these relations is removed
 * If oldT = null, only add (s, newT)
 * @throws PersistenceException 
 */
	public void change(S s, T oldT, T newT) throws PersistenceException {
		this.addElement(s, newT);
		this.removeElement(s, oldT);  
		this.invariantCheck();
	}
/**	
 * If (s,t) is not present, inserts (s,t) without persisting it 
 */
	public void setAlreadyPersistent(S s, T t) {
		if(this.SIndex.containsKey(s) && this.SIndex.get(s).contains(t)) return;
		this.addElementAlreadyPersistent(s, t);
		this.invariantCheck();
	}
/**
 * Unchecked and unrestricted removal of a relation element
 * Returns false, 																	if (s,t) \not\in R
 * Returns true and removes THE LAST relation element with the given projections, otherwise
 * Deletes exactly one entry from the database
 * 
 * To enforce remove o add = id, <remove> must remove beginning from the end
 * @throws PersistenceException 
 */
	public boolean removeElement(S s, T t) throws PersistenceException {
		if(s==null || t == null) return false; 
		boolean result = false;
		ListIterator<RelElement<S, T>> listIterator = this.elements.listIterator(this.elements.size());
		while(listIterator.hasPrevious()) {
			RelElement<S, T> current = listIterator.previous();
			if(current.getFirstProjection().getId().equals(s.getId()) && current.getSecondProjection().getId().equals(t.getId())) {
				listIterator.remove();
				try {
					this.dmlExecuter.deleteFromRelationTable(relationname, s.getId(), t.getId());
				}catch(SQLException | NoConnectionException e) {
					throw new PersistenceException(e.getMessage());
				}
				result = true;
				this.indexRemove(s, t, SIndex);
				this.indexRemove(t, s, TIndex);
				break;
			}
		}
		this.invariantCheck();
		return result;
	}

// Object deletion must be preceded by removal of relation elements which contain the object	
// TODO: Currently, we re-use "removeElement(s,t)" which may be very inperformant -> find faster way!
/**
 * Removes the subset {(s,target) \in R | s\in S} from this relation
 */
	public void removeAllPairsWithTarget(T target) {
		if(!TIndex.containsKey(target)) return;		
// Remove elements along a COPY of TIndex.get(target) (avoiding concurrent modifications when removing the last element, hence the entry in the index)		
		List<S> copiedSources = new ArrayList<>(TIndex.get(target));
		for (S source : copiedSources) this.removeElement(source, target);
		this.invariantCheck();
	}
/**
 * Removes the subset {(source,t) \in R | t\in T} from this relation
 */	
	public void removeAllPairsWithSource(S source) {
		if(!SIndex.containsKey(source)) return;
		List<T> copiedTargets = new ArrayList<>(SIndex.get(source)); // See comment in removeAllSources
		for (T target : copiedTargets) this.removeElement(source, target);
		this.invariantCheck();
	}
// Constraint Violation Checks after adding (s,tNew) or removing (s,tOld) or both
/**	
 * If tNew is already in the relation ( (s',tNew) \in R ) and if s'!=s , then injectivity will be violated, if (s,tNew) is added 
 */
	public void willViolateInjectivity(S s, T tNew) throws ConstraintViolation {
		if(TIndex.keySet().contains(tNew) && !TIndex.get(tNew).contains(s)) 
			throw new ConstraintViolation(Texts.injectivityConstraintViolated);
	}
/**	
 * If tOld is in the relation and R^{-1}(tOld} = {s}, then surjectivity will be violated, if (s,tOld) is removed 
 */	
	public void willViolateSurjectivity(S s, T tOld) throws ConstraintViolation {
		if(TIndex.keySet().contains(tOld) && TIndex.get(tOld).size() == 1 && TIndex.get(tOld).get(0).getId().equals(s.getId()))
			throw new ConstraintViolation(Texts.surjectivityConstraintViolated);
	}
/**	
 * If tOld is contained in s, then the constraint will be violated, if (s,tOld) will be replaced by (s,tNew) and tNew!=tOld 
 * Note that tOld maybe null, thus injectivity violation will occur
 */		
	public void willViolateContainment(S s, T tOld, T tNew) throws ConstraintViolation {
		if(tOld==tNew) return;
		try {
			this.willViolateSurjectivity(s, tOld);
			this.willViolateInjectivity(s, tNew);
		}catch(ConstraintViolation cv) {
			throw new ConstraintViolation(Texts.containmentConstraintViolated);
		}
	}
	
// ============= Private Part ========================== 	
	private <A extends Identifiable,B extends Identifiable> void indexAdd(A a, B b, Map<A,List<B>> index){
		if(index.containsKey(a)) 
			index.get(a).add(b);
		else {
			List<B> bList = new ArrayList<B>();
			bList.add(b);
			index.put(a, bList);
		}			
	}
/**
 * REQUIRES (a,b)\in R	
 * Removes the LAST element x with x==b in XIndex.get(a) 
 */
	private <A extends Identifiable,B extends Identifiable> void indexRemove(A a, B b, Map<A,List<B>> index){
		this.removeLastElementOf(index.get(a),b);
		if(index.get(a).isEmpty()) index.remove(a);		
	}
/**	
 * Removes the last occurence of x from list, only used from outside by tests
 */
	public <X extends Identifiable> void removeLastElementOf(List<X> list, X x) {
		ListIterator<X> listIterator = list.listIterator(list.size());
		while (listIterator.hasPrevious()) {
			X current = listIterator.previous();
			if(x.getId().equals(current.getId())) {
				listIterator.remove();
				break;
			}
		}
	}
	
// ==================== Invariant assertion ==========================
	private void invariantCheck() {
		for (S source : SIndex.keySet()) 
			assert ListUtilities.sameElements(this.getRelatedTargets(source), this.retrieveTargetsFromElementsFor(source)) : "Fatal Error: Inconsistency in Relation: In SIndex:" + this.getRelatedTargets(source) + ", in elements: " + this.retrieveTargetsFromElementsFor(source);	
		for (T target : TIndex.keySet()) 
			assert ListUtilities.sameElements(this.getRelatedSources(target), this.retrieveSourcesFromElementsFor(target)) : "Fatal Error: Inconsistency in Relation: In TIndex:" + this.getRelatedSources(target) + ", in elements: " + this.retrieveSourcesFromElementsFor(target);
		for (S s : SIndex.keySet()) assert !SIndex.get(s).isEmpty()	: "Fatal Error: Inconsistency in Relation: In SIndex: List for key " + s + " is empty."; 
		for (T t : TIndex.keySet()) assert !TIndex.get(t).isEmpty()	: "Fatal Error: Inconsistency in Relation: In TIndex: List for key " + t + " is empty.";
		assert noNullValue() : "Fatal error: Null Values in elements of relation";
	}
	private List<T> retrieveTargetsFromElementsFor(S s){
		return this.elements.stream().filter(r -> (r.getFirstProjection().getId().equals(s.getId()))).map(r->r.getSecondProjection()).collect(Collectors.toList());
	}
	private List<S> retrieveSourcesFromElementsFor(T t){
		return this.elements.stream().filter(r -> (r.getSecondProjection().getId().equals(t.getId()))).map(r->r.getFirstProjection()).collect(Collectors.toList());
	}
	private boolean noNullValue() {
		return this.elements.stream().allMatch(r->r.getFirstProjection()!=null && r.getSecondProjection()!=null);
	}	
}
