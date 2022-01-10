/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_delete_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = -443544873L;
   public User_delete_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{User.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
