/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Hall_RowSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Hall_RowSupervisor theInstance = new Hall_RowSupervisor();
   private Relation<IHall, ISeatingRow> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Hall_RowSupervisor(){
      this.elements = new Relation<>("Hall_Row");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Hall_RowSupervisor getInstance(){return theInstance;}
   public Relation<IHall, ISeatingRow> getRelationData() {
      return this.elements;
   }
   public List<ISeatingRow> getRows(IHall owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IHall owner, ISeatingRow target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(IHall owner, ISeatingRow target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IHall owner, ISeatingRow target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateSurjectivity(owner, target);
      return this.elements.removeElement(owner,target);
   }
   public IHall getHall(ISeatingRow target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
