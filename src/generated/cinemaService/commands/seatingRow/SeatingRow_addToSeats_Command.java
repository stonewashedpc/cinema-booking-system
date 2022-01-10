/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_addToSeats_Command extends ObjectCommand<SeatingRow, Void>{
   private static final long serialVersionUID = 1687588377L;
   private Seat arg;
   public SeatingRow_addToSeats_Command(SeatingRow receiver, Seat arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToSeats(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
