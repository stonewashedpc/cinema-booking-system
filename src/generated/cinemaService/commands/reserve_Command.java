/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class reserve_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = -2121514765L;
   private User user;
   private Seat seat;
   private CShow show;
   public reserve_Command(User user, Seat seat, CShow show){
      super();
      this.user = user;
      this.seat = seat;
      this.show = show;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().reserve(user, seat, show);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
