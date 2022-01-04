/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Reservation_constructor_Command extends ServiceCommand<Reservation>{
   private static final long serialVersionUID = 1198071817L;
   private User  user;
   private CShow  show;
   public Reservation_constructor_Command(User  user, CShow  show){
      super();
      this.user = user;
      this.show = show;
   }
   public void execute(){
      try{this.result = Reservation.createFresh(user, show);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
