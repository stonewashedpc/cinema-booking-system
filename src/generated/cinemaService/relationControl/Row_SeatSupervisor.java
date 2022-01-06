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
import exceptions.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Row_SeatSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Row_SeatSupervisor theInstance = new Row_SeatSupervisor();
   private Relation<ISeatingRow, ISeat> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Row_SeatSupervisor(){
      this.elements = new Relation<>("Row_Seat");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Row_SeatSupervisor getInstance(){return theInstance;}
   public Relation<ISeatingRow, ISeat> getRelationData() {
      return this.elements;
   }
   public List<ISeat> getSeats(ISeatingRow owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(ISeatingRow owner, ISeat target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(ISeatingRow owner, ISeat target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(ISeatingRow owner, ISeat target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateSurjectivity(owner, target);
      return this.elements.removeElement(owner,target);
   }
   public ISeatingRow getRow(ISeat target){
      return this.elements.getRelatedSources(target).get(0);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
