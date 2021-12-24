/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
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
import exceptions.ConstraintViolation;
import generated.cinemaService.relationControl.User_Has_PasswordSupervisor;
import generated.cinemaService.relationControl.User_Has_RoleSupervisor;
import java.util.List;

import authentication.AuthenticationService;
import generated.cinemaService.proxies.IReservation;
import generated.cinemaService.relationControl.User_ReservationSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.UserProxy;
import observation.Observable;
import generated.cinemaService.proxies.IUser;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class User extends Observable implements java.io.Serializable, IUser
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String username;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User(Integer id, Password password, Role role, String username, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      User_Has_PasswordSupervisor.getInstance().set(this, password);
      User_Has_RoleSupervisor.getInstance().set(this, role);
      this.username = username;
      if(objectOnly) return;
   }
   public static User createFresh(Password password, Role role, String username)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("User", "id, typeKey, username", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "User").toString() + ", " + "'" + username + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      User me = new User(id, password, role, username, false);
      CinemaService.getInstance().addUserProxy(new UserProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getUserCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      User toBeDeleted = CinemaService.getInstance().getUser(id);
      User_Has_PasswordSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      User_Has_RoleSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      List<IReservation> targetsInUser_Reservation = User_ReservationSupervisor.getInstance().getRelationData().getRelatedTargets(toBeDeleted);
      if(targetsInUser_Reservation.size()>0) throw new ConstraintViolation(" Deletion not possible: Object still contains other objects in Association User_Reservation");
      User_ReservationSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      CinemaService.getInstance().getUserCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("User", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static User instantiateRuntimeCopy(UserProxy proxy, Password password, Role role, String username)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new User(proxy.getId(), password, role, username, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public User getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IUser)) return false;
      return ((IUser)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Password getPassword() throws PersistenceException{
      return User_Has_PasswordSupervisor.getInstance().getPassword(this).getTheObject();
   }
   public void setPassword(Password newPassword)throws PersistenceException{
      User_Has_PasswordSupervisor.getInstance().change(this, this.getPassword(), newPassword);
   }
   public Role getRole() throws PersistenceException{
      return User_Has_RoleSupervisor.getInstance().getRole(this).getTheObject();
   }
   public void setRole(Role newRole)throws PersistenceException{
      User_Has_RoleSupervisor.getInstance().change(this, this.getRole(), newRole);
   }
   public List<Reservation> getReservations() throws PersistenceException{
      List<Reservation> result = new ArrayList<>();
      for (IReservation i : User_ReservationSupervisor.getInstance().getReservations(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      User_ReservationSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      return User_ReservationSupervisor.getInstance().remove(this, arg);
   }
   public String getUsername() {
      return this.username;
   }
   public void setUsername(String newUsername) throws PersistenceException{
      this.username = newUsername;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("User", "username", "'" + newUsername + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public String login(String password)throws AuthenticationException{
      return AuthenticationService.getInstance().loginUser(this.username, password);
   }
/**
 * 
 */
   public void logout(String authToken)throws AuthenticationException{
      AuthenticationService.getInstance().logoutUser(authToken);
   }
//90 ===== GENERATED: End of Your Operations ======
}
