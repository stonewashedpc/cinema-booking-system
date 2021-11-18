/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class Password_constructor_Command extends ServiceCommand<Password>{
   private static final long serialVersionUID = 1415464863L;
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
