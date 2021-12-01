/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_delete_Command extends ObjectCommand<Hall, Void>{
   private static final long serialVersionUID = 1516625267L;
   public Hall_delete_Command(Hall receiver){
      super(receiver);
   }
   public void execute(){
      try{Hall.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
