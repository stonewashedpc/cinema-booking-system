/**--- Generated at Thu Jan 06 20:00:51 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.commands;
import generated.cinemaService.*;
import commands.*;
public class getAdminStatus_Command extends ServiceCommand<Boolean>{
   private static final long serialVersionUID = -1216103880L;
   private String authToken;
   public getAdminStatus_Command(String authToken){
      super();
      this.authToken = authToken;
   }
   public void execute(){
      try{this.result = CinemaService.getInstance().getAdminStatus(authToken);
      }catch(Exception e){this.e = e;
      }finally{CinemaService.getInstance().notifyObservers(this);}
   }
}
