/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_delete_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = -2013498421L;
   public Reservation_delete_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{Reservation.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
