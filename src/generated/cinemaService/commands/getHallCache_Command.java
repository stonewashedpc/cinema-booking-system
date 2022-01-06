/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getHallCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.HallProxy>>{
   private static final long serialVersionUID = 868164611L;
   public getHallCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getHallCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
