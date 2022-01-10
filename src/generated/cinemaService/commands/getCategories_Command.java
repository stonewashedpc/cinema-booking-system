/**--- Generated at Mon Jan 10 22:18:08 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class getCategories_Command extends ServiceCommand<Collection<Category>>{
   private static final long serialVersionUID = 2078521944L;
   public getCategories_Command(){
      super();
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getCategories();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
