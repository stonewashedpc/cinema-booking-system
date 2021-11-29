/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import java.util.List;
import generated.cinemaService.proxies.IReservation;
import generated.cinemaService.relationControl.Booking_For_ReservationSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.BookingProxy;
import observation.Observable;
import generated.cinemaService.proxies.IBooking;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Booking extends Observable implements java.io.Serializable, IBooking
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Booking(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
      if(objectOnly) return;
   }
   public static Booking createFresh()throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Booking", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Booking").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Booking me = new Booking(id, false);
      CinemaService.getInstance().addBookingProxy(new BookingProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getBookingCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Booking toBeDeleted = CinemaService.getInstance().getBooking(id);
      List<IReservation> targetsInBooking_For_Reservation = Booking_For_ReservationSupervisor.getInstance().getRelationData().getRelatedTargets(toBeDeleted);
      if(targetsInBooking_For_Reservation.size()>0) throw new ConstraintViolation(" Deletion not possible: Object still contains other objects in Association Booking_For_Reservation");
      Booking_For_ReservationSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      CinemaService.getInstance().getBookingCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Booking", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Booking instantiateRuntimeCopy(BookingProxy proxy){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Booking(proxy.getId(), true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Booking getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBooking)) return false;
      return ((IBooking)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<Reservation> getReservation() throws PersistenceException{
      Optional<IReservation> opt = Booking_For_ReservationSupervisor.getInstance().getReservation(this);
      return opt.isPresent() ? Optional.of(Booking_For_ReservationSupervisor.getInstance().getReservation(this).get().getTheObject()) : Optional.empty();
   }
   public void setReservation(Reservation newReservation)throws ConstraintViolation, PersistenceException{
      if(this.getReservation().isPresent()) Booking_For_ReservationSupervisor.getInstance().change(this, this.getReservation().get(), newReservation); else Booking_For_ReservationSupervisor.getInstance().set(this, newReservation);
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public void cancel(){
      // TODO: Implement Operation cancel
      return;
   }
//90 ===== GENERATED: End of Your Operations ======
}
