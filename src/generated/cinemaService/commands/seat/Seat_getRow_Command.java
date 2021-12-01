/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seat;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Seat_getRow_Command extends ObjectCommand<Seat, Collection<SeatingRow>>{
   private static final long serialVersionUID = -2091400928L;
   public Seat_getRow_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getRow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
