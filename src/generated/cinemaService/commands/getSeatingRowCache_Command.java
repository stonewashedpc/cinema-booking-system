/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getSeatingRowCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.SeatingRowProxy>>{
   private static final long serialVersionUID = -1154934753L;
   public getSeatingRowCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getSeatingRowCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
