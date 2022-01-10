/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class CShow_getReservations_Command extends ObjectCommand<CShow, Collection<Reservation>>{
   private static final long serialVersionUID = 622116180L;
   public CShow_getReservations_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservations();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
