/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class CShow_getReservations_Command extends ObjectCommand<CShow, Collection<Reservation>>{
   private static final long serialVersionUID = -5931202L;
   public CShow_getReservations_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservations();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
