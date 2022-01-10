/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_removeFromReservations_Command extends ObjectCommand<CShow, Boolean>{
   private static final long serialVersionUID = 1905440014L;
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
