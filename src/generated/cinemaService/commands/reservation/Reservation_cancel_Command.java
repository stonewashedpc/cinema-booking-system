/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_cancel_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = -1366417903L;
   public Reservation_cancel_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.cancel();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
