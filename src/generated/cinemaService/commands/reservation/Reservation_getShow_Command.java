/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_getShow_Command extends ObjectCommand<Reservation, CShow>{
   private static final long serialVersionUID = 1185984242L;
   public Reservation_getShow_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getShow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
