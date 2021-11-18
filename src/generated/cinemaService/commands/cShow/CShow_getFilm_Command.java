/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_getFilm_Command extends ObjectCommand<CShow, Film>{
   private static final long serialVersionUID = -352563187L;
   public CShow_getFilm_Command(CShow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getFilm();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
