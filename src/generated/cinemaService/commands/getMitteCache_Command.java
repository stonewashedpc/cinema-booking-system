/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getMitteCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.MitteProxy>>{
   private static final long serialVersionUID = 1637123269L;
   public getMitteCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getMitteCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
