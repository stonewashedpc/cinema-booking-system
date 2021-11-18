/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.password;
import generated.cinemaService.*;
import commands.*;
public class Password_checkPassword_Command extends ObjectCommand<Password, Boolean>{
   private static final long serialVersionUID = 900347886L;
   private String pw;
   public Password_checkPassword_Command(Password receiver, String pw){
      super(receiver);
      this.pw = pw;
   }
   public void execute(){
      try{this.result = this.receiver.checkPassword(pw);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
