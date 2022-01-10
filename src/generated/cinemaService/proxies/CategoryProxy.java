/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.Category;
import java.util.Optional;
public abstract class CategoryProxy implements ICategory{
   public abstract Category getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ICategory)) return false;
      return ((ICategory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<Integer> getPrice() {
      return this.getTheObject().getPrice();
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.getTheObject().setPrice(newPrice);
   }
   public Optional<String> getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
}
