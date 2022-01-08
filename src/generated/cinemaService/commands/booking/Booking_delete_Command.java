/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.booking;
import generated.cinemaService.*;
import commands.*;
public class Booking_delete_Command extends ObjectCommand<Booking, Void>{
   private static final long serialVersionUID = 668731164L;
   public Booking_delete_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{Booking.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
