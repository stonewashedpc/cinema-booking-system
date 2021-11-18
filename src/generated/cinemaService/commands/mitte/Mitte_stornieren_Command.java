/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.mitte;
import generated.cinemaService.*;
import commands.*;
public class Mitte_stornieren_Command extends ObjectCommand<Mitte, Void>{
   private static final long serialVersionUID = 2139366518L;
   public Mitte_stornieren_Command(Mitte receiver){
      super(receiver);
   }
   public void execute(){
      try{this.receiver.stornieren();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
