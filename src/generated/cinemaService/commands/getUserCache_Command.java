/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getUserCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.UserProxy>>{
   private static final long serialVersionUID = -44801533L;
   public getUserCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getUserCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
