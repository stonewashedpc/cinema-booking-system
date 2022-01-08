/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_addToShow_Command extends ObjectCommand<Hall, Void>{
   private static final long serialVersionUID = 1990016573L;
   private CShow arg;
   public Hall_addToShow_Command(Hall receiver, CShow arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToShow(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
