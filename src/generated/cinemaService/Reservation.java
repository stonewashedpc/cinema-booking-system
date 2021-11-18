/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
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
import generated.cinemaService.relationControl.User_ReservationSupervisor;
import generated.cinemaService.relationControl.Booking_For_ReservationSupervisor;
import generated.cinemaService.relationControl.Reservation_ShowSupervisor;
import generated.cinemaService.relationControl.Reservation_SeatSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.ReservationProxy;
import observation.Observable;
import generated.cinemaService.proxies.IReservation;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.List;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reservation extends Observable implements java.io.Serializable, IReservation
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation(Integer id, User user, Booking booking, CShow show, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super();
      this.setId(id);
      if(objectOnly) return;
      try{User_ReservationSupervisor.getInstance().add(user,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
      if(booking.getReservation().isPresent()) throw new ConstraintViolation("Object cannot be instantiated, because " + booking+ " is full");
      try{Booking_For_ReservationSupervisor.getInstance().set(booking,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
      try{Reservation_ShowSupervisor.getInstance().add(show,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Reservation createFresh(User user, Booking booking, CShow show)throws PersistenceException, ConstraintViolation{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Reservation", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Reservation").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reservation me = new Reservation(id, user, booking, show, false);
      CinemaService.getInstance().addReservationProxy(new ReservationProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getReservationCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Reservation toBeDeleted = CinemaService.getInstance().getReservation(id);
      User_ReservationSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      Booking_For_ReservationSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      Reservation_ShowSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      Reservation_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      CinemaService.getInstance().getReservationCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Reservation", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reservation instantiateRuntimeCopy(ReservationProxy proxy, User user, Booking booking, CShow show)throws PersistenceException, ConstraintViolation{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reservation(proxy.getId(), user, booking, show, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Reservation getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Seat> getSeat() throws PersistenceException{
      List<Seat> result = new ArrayList<>();
      for (ISeat i : Reservation_SeatSupervisor.getInstance().getSeat(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSeat(Seat arg) throws PersistenceException{
      Reservation_SeatSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSeat(Seat arg) throws PersistenceException{
      return Reservation_SeatSupervisor.getInstance().remove(this, arg);
   }
   public User getUser() throws PersistenceException{
      return User_ReservationSupervisor.getInstance().getUser(this).getTheObject();
   }
   public Booking getBooking() throws PersistenceException{
      return Booking_For_ReservationSupervisor.getInstance().getBooking(this).getTheObject();
   }
   public CShow getShow() throws PersistenceException{
      return Reservation_ShowSupervisor.getInstance().getShow(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public void cancel(){
      // TODO: Implement Operation cancel
      return;
   }
/**
 * 
 */
   public Booking book(){
      // TODO: Implement Operation book
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
