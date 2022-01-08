/**--- Generated at Sat Jan 08 19:03:33 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getFilms_Command extends ServiceCommand<Collection<Film>>{
   private static final long serialVersionUID = -444068135L;
   public getFilms_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getFilms();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
