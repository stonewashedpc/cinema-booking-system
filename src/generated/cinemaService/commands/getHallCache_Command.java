/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getHallCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.HallProxy>>{
   private static final long serialVersionUID = 1489956036L;
   public getHallCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getHallCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
