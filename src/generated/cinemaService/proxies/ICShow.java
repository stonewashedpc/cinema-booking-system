/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
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
