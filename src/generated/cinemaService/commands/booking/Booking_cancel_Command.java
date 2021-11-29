/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.booking;
import generated.cinemaService.*;
import commands.*;
public class Booking_cancel_Command extends ObjectCommand<Booking, Void>{
   private static final long serialVersionUID = -705017320L;
   public Booking_cancel_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.cancel();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
