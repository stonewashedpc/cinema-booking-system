/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.CShow;
import generated.cinemaService.Reservation;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.cinemaService.Film;
import generated.cinemaService.Hall;
public interface ICShow extends Identifiable{
   public CShow getTheObject();
   public Integer getId();
   public List<Reservation> getReservations() throws PersistenceException;
   public void addToReservations(Reservation arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromReservations(Reservation arg) throws ConstraintViolation, PersistenceException;
   public Film getFilm() throws PersistenceException;
   public void setFilm(Film newFilm)throws PersistenceException;
   public Boolean getReservable() ;
   public void setReservable(Boolean newReservable) throws PersistenceException;
   public Hall getHall() throws PersistenceException;
}
