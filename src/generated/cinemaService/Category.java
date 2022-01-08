/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.cinemaService.proxies.ICategory;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class Category extends Observable implements java.io.Serializable, ICategory
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Optional<Integer> price;
   private Optional<String> name;
   //40 ===== Editable : Your Attribute Section ======
   //50 ===== GENERATED:      Constructor ============
   public Category(Integer id, Optional<Integer> price, Optional<String> name, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.price = price;
      this.name = name;
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Category getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICategory)) return false;
      return ((ICategory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<Integer> getPrice() {
      return this.price;
   }
   public void setPrice(Integer newPrice) throws PersistenceException{
      this.price = Optional.of(newPrice);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Category", "price", newPrice.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Optional<String> getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = Optional.of(newName);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Category", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
