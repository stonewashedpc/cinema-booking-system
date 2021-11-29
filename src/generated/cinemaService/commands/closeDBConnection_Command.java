/**--- Generated at Sun Nov 28 22:50:59 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class closeDBConnection_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -1287872476L;
   public closeDBConnection_Command(){
      super();
   }
   public void execute(){
      try{CinemaService.getInstance().closeDBConnection();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
