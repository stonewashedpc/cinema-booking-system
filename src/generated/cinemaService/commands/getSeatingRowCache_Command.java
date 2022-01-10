/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getSeatingRowCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.SeatingRowProxy>>{
   private static final long serialVersionUID = -979340130L;
   public getSeatingRowCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getSeatingRowCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
