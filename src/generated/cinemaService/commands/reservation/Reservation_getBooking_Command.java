/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_getBooking_Command extends ObjectCommand<Reservation, java.util.Optional<Booking>>{
   private static final long serialVersionUID = 1339059562L;
   public Reservation_getBooking_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getBooking();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
