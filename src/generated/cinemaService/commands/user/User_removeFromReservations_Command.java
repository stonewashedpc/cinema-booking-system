/**--- Generated at Tue Dec 21 20:30:53 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
public class User_removeFromReservations_Command extends ObjectCommand<User, Boolean>{
   private static final long serialVersionUID = -1675966442L;
   private Reservation arg;
   public User_removeFromReservations_Command(User receiver, Reservation arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromReservations(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
