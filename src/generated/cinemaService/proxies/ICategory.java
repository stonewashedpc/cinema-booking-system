/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Category;
import java.util.Optional;
public interface ICategory extends Identifiable{
   public Category getTheObject();
   public Optional<Integer> getPrice() ;
   public void setPrice(Integer newPrice) throws PersistenceException;
   public Optional<String> getName() ;
   public void setName(String newName) throws PersistenceException;
}
