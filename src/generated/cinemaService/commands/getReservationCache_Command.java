/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getReservationCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.ReservationProxy>>{
   private static final long serialVersionUID = -2014540066L;
   public getReservationCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getReservationCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}