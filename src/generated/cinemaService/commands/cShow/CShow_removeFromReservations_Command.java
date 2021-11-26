/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_removeFromReservations_Command extends ObjectCommand<CShow, Boolean>{
   private static final long serialVersionUID = 1212433139L;
   private Reservation arg;
   public CShow_removeFromReservations_Command(CShow receiver, Reservation arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromReservations(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
