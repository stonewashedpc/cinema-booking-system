/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class CShow_constructor_Command extends ServiceCommand<CShow>{
   private static final long serialVersionUID = -1212523758L;
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
