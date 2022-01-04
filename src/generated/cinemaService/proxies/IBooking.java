/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Booking;
import generated.cinemaService.Reservation;
public interface IBooking extends Identifiable{
   public Booking getTheObject();
   public Integer getId();
   public Reservation getReservation() throws PersistenceException;
}
