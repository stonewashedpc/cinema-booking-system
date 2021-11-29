/**--- Generated at Sun Nov 28 22:50:59 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_delete_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = 1720479903L;
   public User_delete_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{User.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
