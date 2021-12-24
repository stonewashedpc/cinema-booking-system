/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
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
public class Reservation_ShowSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Reservation_ShowSupervisor theInstance = new Reservation_ShowSupervisor();
   private Relation<ICShow, IReservation> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation_ShowSupervisor(){
      this.elements = new Relation<>("Reservation_Show");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Reservation_ShowSupervisor getInstance(){return theInstance;}
   public Relation<ICShow, IReservation> getRelationData() {
      return this.elements;
   }
   public List<IReservation> getReservations(ICShow owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(ICShow owner, IReservation target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(ICShow owner, IReservation target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ICShow owner, IReservation target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateSurjectivity(owner, target);
      return this.elements.removeElement(owner,target);
   }
   public ICShow getShow(IReservation target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
