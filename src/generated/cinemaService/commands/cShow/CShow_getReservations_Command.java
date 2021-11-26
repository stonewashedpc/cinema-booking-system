/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class CShow_getReservations_Command extends ObjectCommand<CShow, Collection<Reservation>>{
   private static final long serialVersionUID = -340105970L;
   public CShow_getReservations_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservations();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
