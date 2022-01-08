/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class User_Has_PasswordSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static User_Has_PasswordSupervisor theInstance = new User_Has_PasswordSupervisor();
   private Relation<IUser, IPassword> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User_Has_PasswordSupervisor(){
      this.elements = new Relation<>("User_Has_Password");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static User_Has_PasswordSupervisor getInstance(){return theInstance;}
   public Relation<IUser, IPassword> getRelationData() {
      return this.elements;
   }
   public IPassword getPassword(IUser owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IUser owner, IPassword target) throws PersistenceException{
      IPassword targetOld = this.getPassword(owner); IPassword targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IUser owner, IPassword target) {
      IPassword targetOld = null; IPassword targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IUser owner, IPassword targetOld, IPassword targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
