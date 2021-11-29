/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_removeShow_Command extends ObjectCommand<Hall, Void>{
   private static final long serialVersionUID = 2049793938L;
   private CShow show;
   public Hall_removeShow_Command(Hall receiver, CShow show){
      super(receiver);
      this.show = show;
   }
   public void execute(){
      try{this.receiver.removeShow(show);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
