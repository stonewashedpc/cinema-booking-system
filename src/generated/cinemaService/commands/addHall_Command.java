/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addHall_Command extends ServiceCommand<Hall>{
   private static final long serialVersionUID = 363099356L;
   private String name;
   public addHall_Command(String name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().addHall(name);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
