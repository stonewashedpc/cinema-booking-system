/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Mitte_constructor_Command extends ServiceCommand<Mitte>{
   private static final long serialVersionUID = 1212624971L;
   public Mitte_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = Mitte.createFresh();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
