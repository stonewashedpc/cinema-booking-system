/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getPasswordCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.PasswordProxy>>{
   private static final long serialVersionUID = -634602780L;
   public getPasswordCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getPasswordCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
