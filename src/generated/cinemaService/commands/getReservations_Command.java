/**--- Generated at Tue Jan 04 20:14:08 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;

import authentication.AuthenticationService;
public class getReservations_Command extends ServiceCommand<Collection<Reservation>>{
   private static final long serialVersionUID = 107583181L;
   public getReservations_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getReservations(AuthenticationService.getInstance().findUser(authToken));
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
