/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.booking;
import generated.cinemaService.*;
import commands.*;
public class Booking_getReservation_Command extends ObjectCommand<Booking, Reservation>{
   private static final long serialVersionUID = -2010682830L;
   public Booking_getReservation_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservation();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
