/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getSeatCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.SeatProxy>>{
   private static final long serialVersionUID = 2073903335L;
   public getSeatCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getSeatCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
