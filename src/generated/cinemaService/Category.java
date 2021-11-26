/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
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
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class Category extends Observable implements java.io.Serializable, ICategory
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public Category(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
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
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
