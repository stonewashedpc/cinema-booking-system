/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Password_constructor_Command extends ServiceCommand<Password>{
   private static final long serialVersionUID = -1231799941L;
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
