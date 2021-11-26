/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class removeFilm_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 328858880L;
   private Film film;
   public removeFilm_Command(Film film){
      super();
      this.film = film;
   }
   public void execute(){
      try{CinemaService.getInstance().removeFilm(film);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
