/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_constructor_Command extends ServiceCommand<Seat>{
   private static final long serialVersionUID = 532007809L;
   private Integer  nr;
   public Seat_constructor_Command(Integer  nr){
      super();
      this.nr = nr;
   }
   public void execute(){
      try{this.result = Seat.createFresh(nr);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
