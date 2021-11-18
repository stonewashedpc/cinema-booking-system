/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Film_constructor_Command extends ServiceCommand<Film>{
   private static final long serialVersionUID = 1663401305L;
   private String  name;
   public Film_constructor_Command(String  name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = Film.createFresh(name);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
