/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.booking;
import generated.cinemaService.*;
import commands.*;
public class Booking_setReservation_Command extends ObjectCommand<Booking, Void>{
   private static final long serialVersionUID = -616528981L;
   private Reservation arg;
   public Booking_setReservation_Command(Booking receiver, Reservation arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setReservation(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
