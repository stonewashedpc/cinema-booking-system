/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getUserByUsername_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 1046688780L;
   private String username;
   public getUserByUsername_Command(String username){
      super();
      this.username = username;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getUserByUsername(username);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
