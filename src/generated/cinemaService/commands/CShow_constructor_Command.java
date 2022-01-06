/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class CShow_constructor_Command extends ServiceCommand<CShow>{
   private static final long serialVersionUID = -462654465L;
   private Film film;
   private Boolean  reservable;
   private Hall  hall;
   public CShow_constructor_Command(Film film, Boolean  reservable, Hall  hall){
      super();
      this.film = film;
      this.reservable = reservable;
      this.hall = hall;
   }
   public void execute(){
      try{this.result = CShow.createFresh(film, reservable, hall);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
