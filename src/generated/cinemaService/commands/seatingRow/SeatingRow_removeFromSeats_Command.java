/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_removeFromSeats_Command extends ObjectCommand<SeatingRow, Boolean>{
   private static final long serialVersionUID = -724960541L;
   private Seat arg;
   public SeatingRow_removeFromSeats_Command(SeatingRow receiver, Seat arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromSeats(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
