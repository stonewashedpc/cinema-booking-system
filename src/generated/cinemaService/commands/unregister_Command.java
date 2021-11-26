/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class unregister_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1868180133L;
   private User user;
   public unregister_Command(User user){
      super();
      this.user = user;
   }
   public void execute(){
      try{CinemaService.getInstance().unregister(user);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
