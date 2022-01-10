/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_getFilm_Command extends ObjectCommand<CShow, Film>{
   private static final long serialVersionUID = 1578781227L;
   public CShow_getFilm_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getFilm();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
