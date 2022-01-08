/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Reservation;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.Booking;
import exceptions.ConstraintViolation;
import generated.cinemaService.Seat;
import java.util.List;
import generated.cinemaService.User;
import generated.cinemaService.relationControl.User_ReservationSupervisor;
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
         CShow show = Reservation_ShowSupervisor.getInstance().getShow(this).getTheObject();
         return Reservation.instantiateRuntimeCopy(this, user, show);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Optional<Booking> getBooking() throws PersistenceException{
      return this.getTheObject().getBooking();
   }
   public void setBooking(Booking newBooking)throws ConstraintViolation, PersistenceException{
      this.getTheObject().setBooking(newBooking);
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
   public CShow getShow() throws PersistenceException{
      return this.getTheObject().getShow();
   }
}
