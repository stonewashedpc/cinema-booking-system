/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;

import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import generated.cinemaService.proxies.IUser;
import generated.cinemaService.relationControl.User_Has_PasswordSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.PasswordProxy;
import observation.Observable;
import generated.cinemaService.proxies.IPassword;
import db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Password extends Observable implements java.io.Serializable, IPassword
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String password;
   private String salt;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Password(Integer id, String password, String salt, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.password = password;
      this.salt = salt;
      if(objectOnly) return;
   }
   public static Password createFresh(String password, String salt)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Password", "id, typeKey, password, salt", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Password").toString() + ", " + "'" + password + "'" + ", " + "'" + salt + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Password me = new Password(id, password, salt, false);
      CinemaService.getInstance().addPasswordProxy(new PasswordProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getPasswordCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Password toBeDeleted = CinemaService.getInstance().getPassword(id);
      List<IUser> ownersInUser_Has_Password = User_Has_PasswordSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInUser_Has_Password.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association User_Has_Password");
      User_Has_PasswordSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      CinemaService.getInstance().getPasswordCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Password", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Password instantiateRuntimeCopy(PasswordProxy proxy, String password, String salt){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Password(proxy.getId(), password, salt, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Password getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IPassword)) return false;
      return ((IPassword)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getPassword() {
      return this.password;
   }
   public void setPassword(String newPassword) throws PersistenceException{
      this.password = newPassword;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Password", "password", "'" + newPassword + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getSalt() {
      return this.salt;
   }
   public void setSalt(String newSalt) throws PersistenceException{
      this.salt = newSalt;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Password", "salt", "'" + newSalt + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public Boolean checkPassword(String pw){
	   byte[] passwordHash = null;
	   try {
		   KeySpec spec = new PBEKeySpec(pw.toCharArray(), Base64.getDecoder().decode(this.salt), 65536, 128);
		   SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		   passwordHash = factory.generateSecret(spec).getEncoded();
	   } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {e.printStackTrace();}
	   return this.password.equals(Base64.getEncoder().encodeToString(passwordHash));
   }
//90 ===== GENERATED: End of Your Operations ======
}
