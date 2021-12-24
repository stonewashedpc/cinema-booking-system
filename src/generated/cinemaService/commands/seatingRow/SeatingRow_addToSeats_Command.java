/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_addToSeats_Command extends ObjectCommand<SeatingRow, Void>{
   private static final long serialVersionUID = -252570796L;
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
