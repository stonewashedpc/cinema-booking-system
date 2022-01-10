/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.seat;
import generated.cinemaService.*;
import commands.*;
public class Seat_getRow_Command extends ObjectCommand<Seat, SeatingRow>{
   private static final long serialVersionUID = -2036588308L;
   public Seat_getRow_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getRow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
