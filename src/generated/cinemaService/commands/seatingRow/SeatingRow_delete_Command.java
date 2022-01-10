/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_delete_Command extends ObjectCommand<SeatingRow, Void>{
   private static final long serialVersionUID = 880309748L;
   public SeatingRow_delete_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{SeatingRow.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
