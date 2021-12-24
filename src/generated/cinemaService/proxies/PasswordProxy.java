/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Password;
import java.sql.ResultSet;
import java.util.Optional;
public class PasswordProxy implements IPassword{
   private Integer id;
   private Optional<Password> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public PasswordProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public PasswordProxy(Password theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Password getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Password";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IPassword)) return false;
      return ((IPassword)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Password load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Password", this.id);
         String password = rs.get().getString("password");
         String salt = rs.get().getString("salt");
         return Password.instantiateRuntimeCopy(this, password, salt);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getPassword() {
      return this.getTheObject().getPassword();
   }
   public void setPassword(String newPassword) throws PersistenceException{
      this.getTheObject().setPassword(newPassword);
   }
   public String getSalt() {
      return this.getTheObject().getSalt();
   }
   public void setSalt(String newSalt) throws PersistenceException{
      this.getTheObject().setSalt(newSalt);
   }
}
