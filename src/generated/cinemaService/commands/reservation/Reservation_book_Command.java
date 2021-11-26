/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.reservation;
import generated.cinemaService.*;
import commands.*;
public class Reservation_book_Command extends ObjectCommand<Reservation, Booking>{
   private static final long serialVersionUID = -985485191L;
   public Reservation_book_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.book();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
