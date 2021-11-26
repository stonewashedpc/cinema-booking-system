/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_logout_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = 196822097L;
   public User_logout_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.logout();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
