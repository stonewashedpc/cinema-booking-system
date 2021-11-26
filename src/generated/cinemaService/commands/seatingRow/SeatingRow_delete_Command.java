/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_delete_Command extends ObjectCommand<SeatingRow, Void>{
   private static final long serialVersionUID = -1031917191L;
   public SeatingRow_delete_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{SeatingRow.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
