/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_getShow_Command extends ObjectCommand<Reservation, CShow>{
   private static final long serialVersionUID = 2000452944L;
   public Reservation_getShow_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getShow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
