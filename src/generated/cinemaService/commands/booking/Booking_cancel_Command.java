/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.booking;
import generated.cinemaService.*;
import commands.*;
public class Booking_cancel_Command extends ObjectCommand<Booking, Void>{
   private static final long serialVersionUID = 1622944798L;
   public Booking_cancel_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.cancel();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
