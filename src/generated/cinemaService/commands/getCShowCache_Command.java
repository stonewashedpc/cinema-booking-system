/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getCShowCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.CShowProxy>>{
   private static final long serialVersionUID = -909474630L;
   public getCShowCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getCShowCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
