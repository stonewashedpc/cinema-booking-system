/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_delete_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = -1563285791L;
   public Reservation_delete_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{Reservation.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
