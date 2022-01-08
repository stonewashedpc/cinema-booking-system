/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getHallCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.HallProxy>>{
   private static final long serialVersionUID = -1697787448L;
   public getHallCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getHallCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
