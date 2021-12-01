/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_getRole_Command extends ObjectCommand<User, Role>{
   private static final long serialVersionUID = 2041620699L;
   public User_getRole_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getRole();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
