/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
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
