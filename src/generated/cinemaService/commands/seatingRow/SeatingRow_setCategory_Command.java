/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_setCategory_Command extends ObjectCommand<SeatingRow, Void>{
   private static final long serialVersionUID = 1137146892L;
   private Category arg;
   public SeatingRow_setCategory_Command(SeatingRow receiver, Category arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setCategory(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
