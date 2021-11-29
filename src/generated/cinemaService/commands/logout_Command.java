/**--- Generated at Sun Nov 28 22:50:59 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class logout_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1903817586L;
   private String authToken;
   public logout_Command(String authToken){
      super();
      this.authToken = authToken;
   }
   public void execute(){
      try{CinemaService.getInstance().logout(authToken);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
