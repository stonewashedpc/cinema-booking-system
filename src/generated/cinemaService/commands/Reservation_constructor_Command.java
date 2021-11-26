/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reservation_constructor_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = -685676806L;
   private User  user;
   private Booking  booking;
   private CShow  show;
   public Reservation_constructor_Command(User  user, Booking  booking, CShow  show){
      super();
      this.user = user;
      this.booking = booking;
      this.show = show;
   }
   public void execute(){
      try{this.result = Reservation.createFresh(user, booking, show);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
