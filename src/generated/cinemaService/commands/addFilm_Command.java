/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addFilm_Command extends ServiceCommand<Film>{
   private static final long serialVersionUID = 1525805155L;
   private String name;
   public addFilm_Command(String name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().addFilm(name);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
