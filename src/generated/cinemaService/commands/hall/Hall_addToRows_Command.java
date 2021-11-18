/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_addToRows_Command extends ObjectCommand<Hall, Void>{
   private static final long serialVersionUID = 162074292L;
   private SeatingRow arg;
   public Hall_addToRows_Command(Hall receiver, SeatingRow arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToRows(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
