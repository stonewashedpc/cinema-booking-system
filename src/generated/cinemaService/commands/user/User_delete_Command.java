/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_delete_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = -428905420L;
   public User_delete_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{User.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
