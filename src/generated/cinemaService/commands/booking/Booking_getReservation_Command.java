/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.booking;
import generated.cinemaService.*;
import commands.*;
public class Booking_getReservation_Command extends ObjectCommand<Booking, Reservation>{
   private static final long serialVersionUID = 1568560403L;
   public Booking_getReservation_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservation();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
