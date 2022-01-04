/**--- Generated at Tue Jan 04 20:50:55 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_isBooked_Command extends ObjectCommand<Reservation, Boolean>{
   private static final long serialVersionUID = -2082300939L;
   public Reservation_isBooked_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.isBooked();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
