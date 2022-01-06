/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class SeatingRow_constructor_Command extends ServiceCommand<SeatingRow>{
   private static final long serialVersionUID = -635225900L;
   private Category category;
   private Integer  nr;
   private Hall  hall;
   public SeatingRow_constructor_Command(Category category, Integer  nr, Hall  hall){
      super();
      this.category = category;
      this.nr = nr;
      this.hall = hall;
   }
   public void execute(){
      try{this.result = SeatingRow.createFresh(category, nr, hall);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
