/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_delete_Command extends ObjectCommand<Hall, Void>{
   private static final long serialVersionUID = 319815693L;
   public Hall_delete_Command(Hall receiver){
      super(receiver);
   }
   public void execute(){
      try{Hall.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
