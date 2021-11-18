/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_delete_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = 845541207L;
   public Reservation_delete_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{Reservation.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
