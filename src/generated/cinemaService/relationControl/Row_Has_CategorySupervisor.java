/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
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
public class Row_Has_CategorySupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Row_Has_CategorySupervisor theInstance = new Row_Has_CategorySupervisor();
   private Relation<ISeatingRow, ICategory> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Row_Has_CategorySupervisor(){
      this.elements = new Relation<>("Row_Has_Category");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Row_Has_CategorySupervisor getInstance(){return theInstance;}
   public Relation<ISeatingRow, ICategory> getRelationData() {
      return this.elements;
   }
   public ICategory getCategory(ISeatingRow owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ISeatingRow owner, ICategory target) throws PersistenceException{
      ICategory targetOld = this.getCategory(owner); ICategory targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(ISeatingRow owner, ICategory target) {
      ICategory targetOld = null; ICategory targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ISeatingRow owner, ICategory targetOld, ICategory targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
