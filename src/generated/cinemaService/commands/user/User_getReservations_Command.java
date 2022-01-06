/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.user;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class User_getReservations_Command extends ObjectCommand<User, Collection<Reservation>>{
   private static final long serialVersionUID = 1139514783L;
   public User_getReservations_Command(User receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservations();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
