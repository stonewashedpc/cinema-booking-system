/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_setRole_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = 1394571343L;
   private Role arg;
   public User_setRole_Command(User receiver, Role arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setRole(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
