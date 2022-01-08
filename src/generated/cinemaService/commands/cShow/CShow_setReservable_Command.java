/**--- Generated at Sat Jan 08 20:19:27 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands.cShow;
import generated.cinemaService.*;
import commands.*;
public class CShow_setReservable_Command extends ObjectCommand<CShow, Void>{
   private static final long serialVersionUID = -423579233L;
   private Boolean reservable;
   public CShow_setReservable_Command(CShow receiver, Boolean reservable){
      super(receiver);
      this.reservable = reservable;
   }
   public void execute(){
      try{this.receiver.setReservable(reservable);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
