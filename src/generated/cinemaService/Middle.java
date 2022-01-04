/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
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
import generated.cinemaService.proxies.IMiddle;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Middle extends Category implements java.io.Serializable, IMiddle
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Middle> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Middle(Integer id, Optional<Integer> price, Optional<String> name, boolean objectOnly)
   {
      super(id, price, name, objectOnly);
      if(objectOnly) return;
   }
   private static Middle instantiateRuntimeCopy(Integer id, Optional<Integer> price, Optional<String> name){
      return new Middle(id, price, name, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Middle getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Middle load() throws PersistenceException {
      try{
         Integer typeKey = PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Middle");
         Optional<ResultSet> rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Category", typeKey);
         if(rs.isPresent()) rs.get().next();
         Integer id = rs.isPresent() ? rs.get().getInt("id") : IDManagerTransient.getTheInstance().getNextId();
         Optional<Integer> price = Optional.empty();
         if(rs.isPresent()) price = (rs.get().getObject("price") == null ? Optional.empty() : Optional.of(rs.get().getInt("price")));
         Optional<String> name = Optional.empty();
         if(rs.isPresent()) name = (rs.get().getObject("name") == null ? Optional.empty() : Optional.of(rs.get().getString("name")));
         return Middle.instantiateRuntimeCopy(id, price, name);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Middle getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
