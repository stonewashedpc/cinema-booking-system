/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.booking;
import generated.cinemaService.*;
import commands.*;
public class Booking_getReservation_Command extends ObjectCommand<Booking, java.util.Optional<Reservation>>{
   private static final long serialVersionUID = -1203948710L;
   public Booking_getReservation_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservation();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
