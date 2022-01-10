/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Password;
public interface IPassword extends Identifiable{
   public Password getTheObject();
   public Integer getId();
   public String getPassword() ;
   public void setPassword(String newPassword) throws PersistenceException;
   public String getSalt() ;
   public void setSalt(String newSalt) throws PersistenceException;
}
