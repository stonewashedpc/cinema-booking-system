/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_delete_Command extends ObjectCommand<CShow, Void>{
   private static final long serialVersionUID = -824684377L;
   public CShow_delete_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{CShow.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
