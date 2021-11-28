/**--- Generated at Sun Nov 28 22:50:59 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_setPassword_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = 1151760454L;
   private Password arg;
   public User_setPassword_Command(User receiver, Password arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setPassword(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
