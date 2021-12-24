/**--- Generated at Fri Dec 24 00:02:50 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_getCategoryName_Command extends ObjectCommand<SeatingRow, String>{
   private static final long serialVersionUID = 1207052476L;
   public SeatingRow_getCategoryName_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getCategoryName();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
