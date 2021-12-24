/**--- Generated at Tue Dec 21 21:28:53 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getReservableShows_Command extends ServiceCommand<Collection<CShow>>{
   private static final long serialVersionUID = -1892132722L;
   public getReservableShows_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getReservableShows();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
