/**--- Generated at Sat Nov 27 15:31:40 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Password_constructor_Command extends ServiceCommand<Password>{
   private static final long serialVersionUID = -1277588589L;
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
