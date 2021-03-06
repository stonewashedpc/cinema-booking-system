/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
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
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Booking_For_ReservationSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Booking_For_ReservationSupervisor theInstance = new Booking_For_ReservationSupervisor();
   private Relation<IReservation, IBooking> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Booking_For_ReservationSupervisor(){
      this.elements = new Relation<>("Booking_For_Reservation");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Booking_For_ReservationSupervisor getInstance(){return theInstance;}
   public Relation<IReservation, IBooking> getRelationData() {
      return this.elements;
   }
   public Optional<IBooking> getBooking(IReservation owner){
      return (this.elements.getRelatedTargets(owner).size() == 0) ? Optional.empty() : Optional.of(this.elements.getRelatedTargets(owner).get(0));
   }
   public void set(IReservation owner, IBooking target) throws ConstraintViolation, PersistenceException{
      IBooking targetOld = this.getBooking(owner).isPresent() ? this.getBooking(owner).get() : null; IBooking targetNew = target;
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IReservation owner, IBooking target) throws ConstraintViolation{
      IBooking targetOld = null; IBooking targetNew = target;
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IReservation owner, IBooking targetOld, IBooking targetNew) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateContainment(owner, targetOld, targetNew);
      this.elements.change(owner, targetOld, targetNew);
   }
   public IReservation getReservation(IBooking target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
