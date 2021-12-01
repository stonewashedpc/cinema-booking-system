/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_constructor_Command extends ServiceCommand<Seat>{
   private static final long serialVersionUID = 1536829308L;
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
