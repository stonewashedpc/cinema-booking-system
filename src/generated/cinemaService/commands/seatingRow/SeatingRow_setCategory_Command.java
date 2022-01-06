/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seatingRow;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_setCategory_Command extends ObjectCommand<SeatingRow, Void>{
   private static final long serialVersionUID = -1084050159L;
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
