/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Reservation;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.Seat;
import java.util.List;
import generated.cinemaService.User;
import generated.cinemaService.relationControl.User_ReservationSupervisor;
import generated.cinemaService.Booking;
import generated.cinemaService.relationControl.Booking_For_ReservationSupervisor;
import generated.cinemaService.CShow;
import generated.cinemaService.relationControl.Reservation_ShowSupervisor;
public class ReservationProxy implements IReservation{
   private Integer id;
   private Optional<Reservation> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ReservationProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReservationProxy(Reservation theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Reservation getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reservation";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reservation load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Reservation", this.id);
         User user = User_ReservationSupervisor.getInstance().getUser(this).getTheObject();
         Booking booking = Booking_For_ReservationSupervisor.getInstance().getBooking(this).getTheObject();
         CShow show = Reservation_ShowSupervisor.getInstance().getShow(this).getTheObject();
         return Reservation.instantiateRuntimeCopy(this, user, booking, show);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Seat> getSeat() throws PersistenceException{
      return this.getTheObject().getSeat();
   }
   public void addToSeat(Seat arg) throws PersistenceException{
      this.getTheObject().addToSeat(arg);
   }
   public boolean removeFromSeat(Seat arg) throws PersistenceException{
      return this.getTheObject().removeFromSeat(arg);
   }
   public User getUser() throws PersistenceException{
      return this.getTheObject().getUser();
   }
   public Booking getBooking() throws PersistenceException{
      return this.getTheObject().getBooking();
   }
   public CShow getShow() throws PersistenceException{
      return this.getTheObject().getShow();
   }
   public void cancel(){
      this.getTheObject().cancel();
   }
   public Booking book(){
      return this.getTheObject().book();
   }
}