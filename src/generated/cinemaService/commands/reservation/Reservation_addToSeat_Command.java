/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_addToSeat_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = -203229344L;
   private Seat arg;
   public Reservation_addToSeat_Command(Reservation receiver, Seat arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToSeat(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
