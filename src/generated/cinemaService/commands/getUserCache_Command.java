/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getUserCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.UserProxy>>{
   private static final long serialVersionUID = 916810908L;
   public getUserCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getUserCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
