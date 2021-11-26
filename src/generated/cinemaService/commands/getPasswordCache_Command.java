/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getPasswordCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.PasswordProxy>>{
   private static final long serialVersionUID = -624199540L;
   public getPasswordCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getPasswordCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
