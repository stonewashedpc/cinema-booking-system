/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_setRole_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = -694637083L;
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