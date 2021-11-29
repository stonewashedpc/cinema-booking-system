/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_addToSeat_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = -323233745L;
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
