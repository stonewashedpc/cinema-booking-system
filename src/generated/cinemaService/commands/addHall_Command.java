/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class addHall_Command extends ServiceCommand<Hall>{
   private static final long serialVersionUID = -308568329L;
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
