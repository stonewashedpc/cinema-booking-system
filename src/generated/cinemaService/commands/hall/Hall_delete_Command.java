/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_delete_Command extends ObjectCommand<Hall, Void>{
   private static final long serialVersionUID = -202991782L;
   public Hall_delete_Command(Hall receiver){
      super(receiver);
   }
   public void execute(){
      try{Hall.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
