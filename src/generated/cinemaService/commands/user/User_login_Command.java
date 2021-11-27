/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_login_Command extends ObjectCommand<User, String>{
   private static final long serialVersionUID = -1546421167L;
   private String password;
   public User_login_Command(User receiver, String password){
      super(receiver);
      this.password = password;
   }
   public void execute(){
      try{this.result = this.receiver.login(password);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
