/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Booking;
import generated.cinemaService.Reservation;
import exceptions.ConstraintViolation;
import java.util.Optional;
public interface IBooking extends Identifiable{
   public Booking getTheObject();
   public Integer getId();
   public Optional<Reservation> getReservation() throws PersistenceException;
   public void setReservation(Reservation newReservation)throws ConstraintViolation, PersistenceException;
}
