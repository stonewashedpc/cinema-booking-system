/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
import java.util.Collection;
public class Hall_getRows_Command extends ObjectCommand<Hall, Collection<SeatingRow>>{
   private static final long serialVersionUID = -623673231L;
   public Hall_getRows_Command(Hall receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getRows();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
