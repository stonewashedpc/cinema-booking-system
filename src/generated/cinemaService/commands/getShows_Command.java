/**--- Generated at Sat Jan 08 19:03:33 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getShows_Command extends ServiceCommand<Collection<CShow>>{
   private static final long serialVersionUID = -1673122977L;
   public getShows_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getShows();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
