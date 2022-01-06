/**--- Generated at Thu Jan 06 20:07:31 CET 2022 
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
public class User_Has_RoleSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static User_Has_RoleSupervisor theInstance = new User_Has_RoleSupervisor();
   private Relation<IUser, IRole> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private User_Has_RoleSupervisor(){
      this.elements = new Relation<>("User_Has_Role");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static User_Has_RoleSupervisor getInstance(){return theInstance;}
   public Relation<IUser, IRole> getRelationData() {
      return this.elements;
   }
   public IRole getRole(IUser owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IUser owner, IRole target) throws PersistenceException{
      IRole targetOld = this.getRole(owner); IRole targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(IUser owner, IRole target) {
      IRole targetOld = null; IRole targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IUser owner, IRole targetOld, IRole targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
