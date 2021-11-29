/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_getCategory_Command extends ObjectCommand<SeatingRow, Category>{
   private static final long serialVersionUID = 2022636600L;
   public SeatingRow_getCategory_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getCategory();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
