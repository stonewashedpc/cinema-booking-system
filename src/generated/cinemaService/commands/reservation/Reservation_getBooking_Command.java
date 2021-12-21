/**--- Generated at Tue Dec 21 20:30:53 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_getBooking_Command extends ObjectCommand<Reservation, java.util.Optional<Booking>>{
   private static final long serialVersionUID = -1607651687L;
   public Reservation_getBooking_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getBooking();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
