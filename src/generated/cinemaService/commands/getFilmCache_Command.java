/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getFilmCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.FilmProxy>>{
   private static final long serialVersionUID = -1252765448L;
   public getFilmCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getFilmCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
