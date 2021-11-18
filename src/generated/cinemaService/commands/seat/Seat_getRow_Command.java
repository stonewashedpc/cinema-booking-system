/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seat;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Seat_getRow_Command extends ObjectCommand<Seat, Collection<SeatingRow>>{
   private static final long serialVersionUID = -1325152299L;
   public Seat_getRow_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getRow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
