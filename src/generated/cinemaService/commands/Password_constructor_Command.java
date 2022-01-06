/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Password_constructor_Command extends ServiceCommand<Password>{
   private static final long serialVersionUID = 1387367715L;
   private String  password;
   private String  salt;
   public Password_constructor_Command(String  password, String  salt){
      super();
      this.password = password;
      this.salt = salt;
   }
   public void execute(){
      try{this.result = Password.createFresh(password, salt);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
