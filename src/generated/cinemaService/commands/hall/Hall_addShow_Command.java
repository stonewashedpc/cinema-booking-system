/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_addShow_Command extends ObjectCommand<Hall, Back>{
   private static final long serialVersionUID = 358555479L;
   private Film film;
   public Hall_addShow_Command(Hall receiver, Film film){
      super(receiver);
      this.film = film;
   }
   public void execute(){
      try{this.result = this.receiver.addShow(film);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
