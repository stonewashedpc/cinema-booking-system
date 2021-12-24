/**--- Generated at Fri Dec 24 00:02:50 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_getPrice_Command extends ObjectCommand<SeatingRow, Integer>{
   private static final long serialVersionUID = -1498574433L;
   public SeatingRow_getPrice_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPrice();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
