/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Seat_constructor_Command extends ServiceCommand<Seat>{
   private static final long serialVersionUID = 926562320L;
   private Integer  nr;
   private SeatingRow  row;
   public Seat_constructor_Command(Integer  nr, SeatingRow  row){
      super();
      this.nr = nr;
      this.row = row;
   }
   public void execute(){
      try{this.result = Seat.createFresh(nr, row);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
