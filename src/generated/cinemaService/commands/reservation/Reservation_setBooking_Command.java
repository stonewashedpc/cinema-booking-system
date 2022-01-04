/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_setBooking_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = 40131375L;
   private Booking arg;
   public Reservation_setBooking_Command(Reservation receiver, Booking arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setBooking(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
