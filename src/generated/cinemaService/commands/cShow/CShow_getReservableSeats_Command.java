/**--- Generated at Thu Dec 23 23:08:51 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class CShow_getReservableSeats_Command extends ObjectCommand<CShow, Collection<Seat>>{
   private static final long serialVersionUID = 1521244242L;
   public CShow_getReservableSeats_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservableSeats();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
