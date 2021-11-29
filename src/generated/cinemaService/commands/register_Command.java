/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class register_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 1382868178L;
   private String name;
   private String password;
   public register_Command(String name, String password){
      super();
      this.name = name;
      this.password = password;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().register(name, password);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
