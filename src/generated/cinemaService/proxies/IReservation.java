/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Reservation;
import generated.cinemaService.Booking;
import exceptions.ConstraintViolation;
import java.util.Optional;
import generated.cinemaService.Seat;
import java.util.List;
import generated.cinemaService.User;
import generated.cinemaService.CShow;
public interface IReservation extends Identifiable{
   public Reservation getTheObject();
   public Integer getId();
   public Optional<Booking> getBooking() throws PersistenceException;
   public void setBooking(Booking newBooking)throws ConstraintViolation, PersistenceException;
   public List<Seat> getSeat() throws PersistenceException;
   public void addToSeat(Seat arg) throws PersistenceException;
   public boolean removeFromSeat(Seat arg) throws PersistenceException;
   public User getUser() throws PersistenceException;
   public CShow getShow() throws PersistenceException;
}
