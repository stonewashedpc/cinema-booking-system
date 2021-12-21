/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.hall;
import generated.cinemaService.*;
import commands.*;
public class Hall_addShow_Command extends ObjectCommand<Hall, CShow>{
   private static final long serialVersionUID = 2079343526L;
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
