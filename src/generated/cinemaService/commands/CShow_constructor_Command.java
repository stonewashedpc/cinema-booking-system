/**--- Generated at Tue Dec 21 20:30:54 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class CShow_constructor_Command extends ServiceCommand<CShow>{
   private static final long serialVersionUID = 1603317235L;
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
