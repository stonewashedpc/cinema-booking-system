/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_calculateTotalIncome_Command extends ObjectCommand<CShow, Integer>{
   private static final long serialVersionUID = 699107228L;
   public CShow_calculateTotalIncome_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.calculateTotalIncome();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
