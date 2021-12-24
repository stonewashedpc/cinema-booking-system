/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.User;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.Password;
import generated.cinemaService.relationControl.User_Has_PasswordSupervisor;
import generated.cinemaService.Role;
import generated.cinemaService.relationControl.User_Has_RoleSupervisor;
import generated.cinemaService.Reservation;
import java.util.List;
import exceptions.ConstraintViolation;
public class UserProxy implements IUser{
   private Integer id;
   private Optional<User> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public UserProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public UserProxy(User theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public User getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "User";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IUser)) return false;
      return ((IUser)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private User load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("User", this.id);
         Password password = User_Has_PasswordSupervisor.getInstance().getPassword(this).getTheObject();
         Role role = User_Has_RoleSupervisor.getInstance().getRole(this).getTheObject();
         String username = rs.get().getString("username");
         return User.instantiateRuntimeCopy(this, password, role, username);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Password getPassword() throws PersistenceException{
      return this.getTheObject().getPassword();
   }
   public void setPassword(Password newPassword)throws PersistenceException{
      this.getTheObject().setPassword(newPassword);
   }
   public Role getRole() throws PersistenceException{
      return this.getTheObject().getRole();
   }
   public void setRole(Role newRole)throws PersistenceException{
      this.getTheObject().setRole(newRole);
   }
   public List<Reservation> getReservations() throws PersistenceException{
      return this.getTheObject().getReservations();
   }
   public void addToReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToReservations(arg);
   }
   public boolean removeFromReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromReservations(arg);
   }
   public String getUsername() {
      return this.getTheObject().getUsername();
   }
   public void setUsername(String newUsername) throws PersistenceException{
      this.getTheObject().setUsername(newUsername);
   }
}
