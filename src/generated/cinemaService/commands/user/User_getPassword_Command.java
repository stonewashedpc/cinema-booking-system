/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_getPassword_Command extends ObjectCommand<User, Password>{
   private static final long serialVersionUID = -1664312029L;
   public User_getPassword_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPassword();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}