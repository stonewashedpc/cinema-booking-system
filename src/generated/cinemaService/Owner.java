/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
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

import authentication.CommandWhitelist;
import authentication.DefaultWhitelist;
import authentication.OwnerWhiteList;

import java.sql.ResultSet;
import idManagement.IDManagerTransient;
import db.executer.PersistenceException;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.IOwner;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Owner extends Role implements java.io.Serializable, IOwner
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Optional<Owner> theInstance = Optional.empty();
   //40 ===== Editable : Your Attribute Section ======
   private CommandWhitelist commandWhitelist = OwnerWhiteList.getInstance();
   //50 ===== GENERATED:      Constructor ============
   private Owner(Integer id, boolean objectOnly)
   {
      super(id, objectOnly);
      if(objectOnly) return;
   }
   private static Owner instantiateRuntimeCopy(Integer id){
      return new Owner(id, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Owner getInstance() throws PersistenceException{
      if(!theInstance.isPresent())theInstance = Optional.of(load());
      return theInstance.get();
   }
   private static Owner load() throws PersistenceException {
      try{
         Integer typeKey = PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Owner");
         Optional<ResultSet> rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectEntriesOfTable("Role", typeKey);
         if(rs.isPresent()) rs.get().next();
         Integer id = rs.isPresent() ? rs.get().getInt("id") : IDManagerTransient.getTheInstance().getNextId();
         return Owner.instantiateRuntimeCopy(id);
      } catch (SQLException | NoConnectionException e) {
         throw new PersistenceException(e.getMessage());
      }
   }
   public Owner getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
   public CommandWhitelist getCommandWhitelist() {
		return commandWhitelist;
	}
//90 ===== GENERATED: End of Your Operations ======
}
