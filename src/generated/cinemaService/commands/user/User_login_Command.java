/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_login_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = -1703772884L;
   public User_login_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.login();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
