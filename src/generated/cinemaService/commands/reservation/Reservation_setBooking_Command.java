/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_setBooking_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = -286661177L;
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
