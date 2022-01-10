/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_getPassword_Command extends ObjectCommand<User, Password>{
   private static final long serialVersionUID = 491577088L;
   public User_getPassword_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPassword();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
