/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
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
   private Booking(Integer id, Reservation reservation, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super();
      this.setId(id);
      if(objectOnly) return;
      if(reservation.getBooking().isPresent()) throw new ConstraintViolation("Object cannot be instantiated, because " + reservation+ " is full");
      try{Booking_For_ReservationSupervisor.getInstance().set(reservation,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Booking createFresh(Reservation reservation)throws ConstraintViolation, PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Booking", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Booking").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Booking me = new Booking(id, reservation, false);
      CinemaService.getInstance().addBookingProxy(new BookingProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getBookingCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Booking toBeDeleted = CinemaService.getInstance().getBooking(id);
      Booking_For_ReservationSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      CinemaService.getInstance().getBookingCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Booking", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Booking instantiateRuntimeCopy(BookingProxy proxy, Reservation reservation)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Booking(proxy.getId(), reservation, true);
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
   public Reservation getReservation() throws PersistenceException{
      return Booking_For_ReservationSupervisor.getInstance().getReservation(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public void cancel(){
	   try {
		Booking.delete(this.getId());
	} catch (ConstraintViolation | SQLException | NoConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
//90 ===== GENERATED: End of Your Operations ======
}
