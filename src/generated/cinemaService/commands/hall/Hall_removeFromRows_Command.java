/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_removeFromRows_Command extends ObjectCommand<Hall, Boolean>{
   private static final long serialVersionUID = 1945889898L;
   private SeatingRow arg;
   public Hall_removeFromRows_Command(Hall receiver, SeatingRow arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromRows(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
