/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class User_getReservations_Command extends ObjectCommand<User, Collection<Reservation>>{
   private static final long serialVersionUID = -1512315071L;
   public User_getReservations_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservations();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
