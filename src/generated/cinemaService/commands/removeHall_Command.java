/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class removeHall_Command extends ServiceCommand<Void>{
   private static final long serialVersionUID = -923560433L;
   private Hall hall;
   public removeHall_Command(Hall hall){
      super();
      this.hall = hall;
   }
   public void execute(){
      try{CinemaService.getInstance().removeHall(hall);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
