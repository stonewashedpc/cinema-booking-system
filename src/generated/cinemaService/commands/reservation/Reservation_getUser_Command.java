/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_getUser_Command extends ObjectCommand<Reservation, User>{
   private static final long serialVersionUID = -19676831L;
   public Reservation_getUser_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getUser();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
