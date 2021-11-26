/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class SeatingRow_getSeats_Command extends ObjectCommand<SeatingRow, Collection<Seat>>{
   private static final long serialVersionUID = -1476020753L;
   public SeatingRow_getSeats_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeats();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
