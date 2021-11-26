/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_removeFromSeat_Command extends ObjectCommand<Reservation, Boolean>{
   private static final long serialVersionUID = -985747604L;
   private Seat arg;
   public Reservation_removeFromSeat_Command(Reservation receiver, Seat arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromSeat(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
