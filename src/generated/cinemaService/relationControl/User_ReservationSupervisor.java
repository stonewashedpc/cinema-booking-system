/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
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
public class User_ReservationSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static User_ReservationSupervisor theInstance = new User_ReservationSupervisor();
   private Relation<IUser, IReservation> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User_ReservationSupervisor(){
      this.elements = new Relation<>("User_Reservation");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static User_ReservationSupervisor getInstance(){return theInstance;}
   public Relation<IUser, IReservation> getRelationData() {
      return this.elements;
   }
   public List<IReservation> getReservations(IUser owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IUser owner, IReservation target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(IUser owner, IReservation target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IUser owner, IReservation target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateSurjectivity(owner, target);
      return this.elements.removeElement(owner,target);
   }
   public IUser getUser(IReservation target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
