/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_logout_Command extends ObjectCommand<User, Void>{
   private static final long serialVersionUID = -1729196593L;
   private String authToken;
   public User_logout_Command(User receiver, String authToken){
      super(receiver);
      this.authToken = authToken;
   }
   public void execute(){
      try{this.receiver.logout(authToken);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
