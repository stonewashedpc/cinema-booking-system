/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class closeDBConnection_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = 1914921076L;
   public closeDBConnection_Command(){
      super();
   }
   public void execute(){
      try{CinemaService.getInstance().closeDBConnection();
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
