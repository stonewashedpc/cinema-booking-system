/**--- Generated at Tue Dec 21 20:30:54 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.film;
import generated.cinemaService.*;
import commands.*;
public class Film_delete_Command extends ObjectCommand<Film, Void>{
   private static final long serialVersionUID = -1839032328L;
   public Film_delete_Command(Film receiver){
      super(receiver);
   }
   public void execute(){
      try{Film.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
