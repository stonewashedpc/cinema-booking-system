/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_delete_Command extends ObjectCommand<CShow, Void>{
   private static final long serialVersionUID = -151032149L;
   public CShow_delete_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{CShow.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
