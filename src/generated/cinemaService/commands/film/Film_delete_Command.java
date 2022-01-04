/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.film;
import generated.cinemaService.*;
import commands.*;
public class Film_delete_Command extends ObjectCommand<Film, Void>{
   private static final long serialVersionUID = -1960304826L;
   public Film_delete_Command(Film receiver){
      super(receiver);
   }
   public void execute(){
      try{Film.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
