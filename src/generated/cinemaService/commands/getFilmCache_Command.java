/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getFilmCache_Command extends ServiceCommand<java.util.Map<Integer, generated.cinemaService.proxies.FilmProxy>>{
   private static final long serialVersionUID = 125554015L;
   public getFilmCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getFilmCache();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
