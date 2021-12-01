/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_setOpenForReservations_Command extends ObjectCommand<CShow, Void>{
   private static final long serialVersionUID = 378773593L;
   public CShow_setOpenForReservations_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.setOpenForReservations();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
