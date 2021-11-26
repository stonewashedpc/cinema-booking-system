/**--- Generated at Fri Nov 26 18:45:12 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class register_Command extends ServiceCommand<User>{
   private static final long serialVersionUID = 531345207L;
   private String name;
   private String password;
   private Role role;
   public register_Command(String name, String password, Role role){
      super();
      this.name = name;
      this.password = password;
      this.role = role;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().register(name, password, role);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
