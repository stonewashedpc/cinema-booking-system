/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class User_constructor_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = -1324017546L;
   private Password password;
   private Role role;
   private String  username;
   public User_constructor_Command(Password password, Role role, String  username){
      super();
      this.password = password;
      this.role = role;
      this.username = username;
   }
   public void execute(){
      try{this.result = User.createFresh(password, role, username);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
