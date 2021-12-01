/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Reservation;
import generated.cinemaService.Seat;
import java.util.List;
import generated.cinemaService.User;
import generated.cinemaService.Booking;
import generated.cinemaService.CShow;
public interface IReservation extends Identifiable{
   public Reservation getTheObject();
   public Integer getId();
   public List<Seat> getSeat() throws PersistenceException;
   public void addToSeat(Seat arg) throws PersistenceException;
   public boolean removeFromSeat(Seat arg) throws PersistenceException;
   public User getUser() throws PersistenceException;
   public Booking getBooking() throws PersistenceException;
   public CShow getShow() throws PersistenceException;
}
