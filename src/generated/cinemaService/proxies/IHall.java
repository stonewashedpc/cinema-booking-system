/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Hall;
import generated.cinemaService.CShow;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.cinemaService.SeatingRow;
public interface IHall extends Identifiable{
   public Hall getTheObject();
   public Integer getId();
   public List<CShow> getShow() throws PersistenceException;
   public void addToShow(CShow arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromShow(CShow arg) throws ConstraintViolation, PersistenceException;
   public List<SeatingRow> getRows() throws PersistenceException;
   public void addToRows(SeatingRow arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromRows(SeatingRow arg) throws ConstraintViolation, PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
}
