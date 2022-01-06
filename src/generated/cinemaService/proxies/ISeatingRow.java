/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.SeatingRow;
import generated.cinemaService.Seat;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.cinemaService.Category;
import generated.cinemaService.Hall;
public interface ISeatingRow extends Identifiable{
   public SeatingRow getTheObject();
   public Integer getId();
   public List<Seat> getSeats() throws PersistenceException;
   public void addToSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromSeats(Seat arg) throws ConstraintViolation, PersistenceException;
   public Category getCategory() throws PersistenceException;
   public void setCategory(Category newCategory)throws PersistenceException;
   public Integer getNr() ;
   public void setNr(Integer newNr) throws PersistenceException;
   public Hall getHall() throws PersistenceException;
}
