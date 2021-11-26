/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.password;
import generated.cinemaService.*;
import commands.*;
public class Password_checkPassword_Command extends ObjectCommand<Password, Boolean>{
   private static final long serialVersionUID = 1393565881L;
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
