/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Hall_getShow_Command extends ObjectCommand<Hall, Collection<CShow>>{
   private static final long serialVersionUID = -1759245144L;
   public Hall_getShow_Command(Hall receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getShow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
