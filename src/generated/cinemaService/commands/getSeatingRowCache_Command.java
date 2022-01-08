/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getSeatingRowCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.SeatingRowProxy>>{
   private static final long serialVersionUID = 172513351L;
   public getSeatingRowCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getSeatingRowCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
