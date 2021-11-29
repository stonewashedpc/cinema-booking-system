/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
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
import java.util.List;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reservation_SeatSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Reservation_SeatSupervisor theInstance = new Reservation_SeatSupervisor();
   private Relation<IReservation, ISeat> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation_SeatSupervisor(){
      this.elements = new Relation<>("Reservation_Seat");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Reservation_SeatSupervisor getInstance(){return theInstance;}
   public Relation<IReservation, ISeat> getRelationData() {
      return this.elements;
   }
   public List<ISeat> getSeat(IReservation owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IReservation owner, ISeat target) throws PersistenceException{
      this.elements.addElement(owner,target);
   }
   /** Used only by service class !! **/
   public void addAlreadyPersistent(IReservation owner, ISeat target) throws PersistenceException{
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IReservation owner, ISeat target) throws PersistenceException{
      return this.elements.removeElement(owner,target);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
