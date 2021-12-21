/**--- Generated at Tue Dec 21 20:30:54 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_getHall_Command extends ObjectCommand<CShow, Hall>{
   private static final long serialVersionUID = -409619468L;
   public CShow_getHall_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getHall();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
