/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class SeatingRow_getSeats_Command extends ObjectCommand<SeatingRow, Collection<Seat>>{
   private static final long serialVersionUID = 1779711089L;
   public SeatingRow_getSeats_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeats();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
