/**--- Generated at Tue Dec 21 20:30:53 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getCShowCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.CShowProxy>>{
   private static final long serialVersionUID = -580586306L;
   public getCShowCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getCShowCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
