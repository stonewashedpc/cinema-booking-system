/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seat;
import generated.cinemaService.*;
import commands.*;
public class Seat_delete_Command extends ObjectCommand<Seat, Void>{
   private static final long serialVersionUID = 196690790L;
   public Seat_delete_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{Seat.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
