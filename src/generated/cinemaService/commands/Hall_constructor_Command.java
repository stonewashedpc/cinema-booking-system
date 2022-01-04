/**--- Generated at Tue Jan 04 20:52:35 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Hall_constructor_Command extends ServiceCommand<Hall>{
   private static final long serialVersionUID = 1437169300L;
   private String  name;
   public Hall_constructor_Command(String  name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = Hall.createFresh(name);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
