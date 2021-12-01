/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Hall_getRows_Command extends ObjectCommand<Hall, Collection<SeatingRow>>{
   private static final long serialVersionUID = -713017765L;
   public Hall_getRows_Command(Hall receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getRows();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
