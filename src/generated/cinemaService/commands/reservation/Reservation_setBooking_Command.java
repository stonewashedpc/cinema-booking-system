/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_setBooking_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = -372503498L;
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