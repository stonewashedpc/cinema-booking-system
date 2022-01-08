/**--- Generated at Sat Jan 08 19:03:33 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getHalls_Command extends ServiceCommand<Collection<Hall>>{
   private static final long serialVersionUID = -1970148065L;
   public getHalls_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getHalls();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
