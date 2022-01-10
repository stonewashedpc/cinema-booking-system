/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class User_getReservations_Command extends ObjectCommand<User, Collection<Reservation>>{
   private static final long serialVersionUID = -367478984L;
   public User_getReservations_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservations();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
