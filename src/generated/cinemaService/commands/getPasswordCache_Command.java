/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getPasswordCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.PasswordProxy>>{
   private static final long serialVersionUID = 239523454L;
   public getPasswordCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getPasswordCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
