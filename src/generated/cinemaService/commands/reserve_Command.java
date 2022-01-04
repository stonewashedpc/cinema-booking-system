/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;

import java.util.Collection;

import authentication.AuthenticationService;
import commands.*;
public class reserve_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = -2121514765L;
   private Collection<Seat> seats;
   private CShow show;
   public reserve_Command(Collection<Seat> seats, CShow show){
      super();
      this.seats = seats;
      this.show = show;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().reserve(AuthenticationService.getInstance().findUser(authToken), seats, show);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
