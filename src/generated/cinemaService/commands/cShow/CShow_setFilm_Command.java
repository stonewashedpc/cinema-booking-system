/**--- Generated at Tue Dec 21 20:30:54 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_setFilm_Command extends ObjectCommand<CShow, Void>{
   private static final long serialVersionUID = -491411929L;
   private Film arg;
   public CShow_setFilm_Command(CShow receiver, Film arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setFilm(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
