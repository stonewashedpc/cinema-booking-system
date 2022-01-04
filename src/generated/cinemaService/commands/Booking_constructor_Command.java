/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Booking_constructor_Command extends ServiceCommand<Booking>{
   private static final long serialVersionUID = -376055170L;
   private Reservation  reservation;
   public Booking_constructor_Command(Reservation  reservation){
      super();
      this.reservation = reservation;
   }
   public void execute(){
      try{this.result = Booking.createFresh(reservation);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
