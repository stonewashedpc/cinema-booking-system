/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_delete_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = -2005237627L;
   public User_delete_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{User.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
