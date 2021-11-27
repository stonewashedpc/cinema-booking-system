/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_delete_Command extends ObjectCommand<CShow, Void>{
   private static final long serialVersionUID = -795415560L;
   public CShow_delete_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{CShow.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
