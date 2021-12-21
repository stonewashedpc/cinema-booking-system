/**--- Generated at Tue Dec 21 20:30:54 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_addToReservations_Command extends ObjectCommand<CShow, Void>{
   private static final long serialVersionUID = -1806251816L;
   private Reservation arg;
   public CShow_addToReservations_Command(CShow receiver, Reservation arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToReservations(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
