/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
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
import generated.cinemaService.AuthenticationException;
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
   public String login(String password)throws AuthenticationException;
   public void logout(String authToken)throws AuthenticationException;
}
