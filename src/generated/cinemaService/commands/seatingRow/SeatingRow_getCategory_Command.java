/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_getCategory_Command extends ObjectCommand<SeatingRow, Category>{
   private static final long serialVersionUID = 113750539L;
   public SeatingRow_getCategory_Command(SeatingRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getCategory();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
