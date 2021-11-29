/**--- Generated at Sun Nov 28 22:50:59 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.User;
import generated.cinemaService.Password;
import generated.cinemaService.Role;
import generated.cinemaService.Reservation;
import java.util.List;
import exceptions.ConstraintViolation;
public interface IUser extends Identifiable{
   public User getTheObject();
   public Integer getId();
   public Password getPassword() throws PersistenceException;
   public void setPassword(Password newPassword)throws PersistenceException;
   public Role getRole() throws PersistenceException;
   public void setRole(Role newRole)throws PersistenceException;
   public List<Reservation> getReservations() throws PersistenceException;
   public void addToReservations(Reservation arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromReservations(Reservation arg) throws ConstraintViolation, PersistenceException;
   public String getUsername() ;
   public void setUsername(String newUsername) throws PersistenceException;
}
