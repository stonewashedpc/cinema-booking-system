/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_getRole_Command extends ObjectCommand<User, Role>{
   private static final long serialVersionUID = -1308564001L;
   public User_getRole_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getRole();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
