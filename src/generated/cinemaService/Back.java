/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
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
import java.util.Optional;
import java.sql.ResultSet;
import idManagement.IDManagerTransient;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.IBack;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Back extends Category implements java.io.Serializable, IBack
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Back> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Back(Integer id, boolean objectOnly)
   {
      super(id, objectOnly);
      if(objectOnly) return;
   }
   private static Back instantiateRuntimeCopy(Integer id){
      return new Back(id, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Back getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Back load() throws PersistenceException {
      try{
         Integer typeKey = PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Back");
         Optional<ResultSet> rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Category", typeKey);
         if(rs.isPresent()) rs.get().next();
         Integer id = rs.isPresent() ? rs.get().getInt("id") : IDManagerTransient.getTheInstance().getNextId();
         return Back.instantiateRuntimeCopy(id);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Back getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
