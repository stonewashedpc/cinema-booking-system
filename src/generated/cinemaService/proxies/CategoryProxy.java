/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import generated.cinemaService.Category;
public abstract class CategoryProxy implements ICategory{
   public abstract Category getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof ICategory)) return false;
      return ((ICategory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
}
