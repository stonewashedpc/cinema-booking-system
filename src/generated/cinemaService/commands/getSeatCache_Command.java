/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getSeatCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.SeatProxy>>{
   private static final long serialVersionUID = -1525955921L;
   public getSeatCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getSeatCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
