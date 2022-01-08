/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;

import authentication.CommandWhitelist;
import authentication.DefaultWhitelist;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.cinemaService.proxies.IRole;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class Role extends Observable implements java.io.Serializable, IRole
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   private CommandWhitelist commandWhitelist = DefaultWhitelist.getInstance();
   //50 ===== GENERATED:      Constructor ============
   public Role(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Role getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRole)) return false;
      return ((IRole)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   //80 ===== Editable : Your Operations =============

   public abstract CommandWhitelist getCommandWhitelist();
   
//90 ===== GENERATED: End of Your Operations ======
}
