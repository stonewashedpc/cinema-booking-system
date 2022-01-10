/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_setPassword_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = -1454053524L;
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
