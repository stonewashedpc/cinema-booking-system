/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_addToRows_Command extends ObjectCommand<Hall, Void>{
   private static final long serialVersionUID = -75305916L;
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
