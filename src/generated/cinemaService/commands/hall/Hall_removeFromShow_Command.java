/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_removeFromShow_Command extends ObjectCommand<Hall, Boolean>{
   private static final long serialVersionUID = -775110465L;
   private CShow arg;
   public Hall_removeFromShow_Command(Hall receiver, CShow arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromShow(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
