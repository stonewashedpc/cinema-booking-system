/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Reservation_getSeat_Command extends ObjectCommand<Reservation, Collection<Seat>>{
   private static final long serialVersionUID = 3098461L;
   public Reservation_getSeat_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeat();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}