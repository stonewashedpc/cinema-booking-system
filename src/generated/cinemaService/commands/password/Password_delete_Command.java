/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.password;
import generated.cinemaService.*;
import commands.*;
public class Password_delete_Command extends ObjectCommand<Password, Void>{
   private static final long serialVersionUID = 355460745L;
   public Password_delete_Command(Password receiver){
      super(receiver);
   }
   public void execute(){
      try{Password.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
