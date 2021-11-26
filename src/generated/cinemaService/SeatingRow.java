/**--- Generated at Fri Nov 26 18:45:13 CET 2021 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import generated.cinemaService.relationControl.Hall_RowSupervisor;
import generated.cinemaService.relationControl.Row_SeatSupervisor;
import generated.cinemaService.relationControl.Row_Has_CategorySupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.SeatingRowProxy;
import observation.Observable;
import generated.cinemaService.proxies.ISeatingRow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.List;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class SeatingRow extends Observable implements java.io.Serializable, ISeatingRow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer nr;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private SeatingRow(Integer id, Category category, Integer nr, Hall hall, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      Row_Has_CategorySupervisor.getInstance().set(this, category);
      this.nr = nr;
      if(objectOnly) return;
      try{Hall_RowSupervisor.getInstance().add(hall,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static SeatingRow createFresh(Category category, Integer nr, Hall hall)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("SeatingRow", "id, typeKey, nr", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "SeatingRow").toString() + ", " + nr.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      SeatingRow me = new SeatingRow(id, category, nr, hall, false);
      CinemaService.getInstance().addSeatingRowProxy(new SeatingRowProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getSeatingRowCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      SeatingRow toBeDeleted = CinemaService.getInstance().getSeatingRow(id);
      Hall_RowSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      Row_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      Row_Has_CategorySupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      CinemaService.getInstance().getSeatingRowCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("SeatingRow", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static SeatingRow instantiateRuntimeCopy(SeatingRowProxy proxy, Category category, Integer nr, Hall hall)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new SeatingRow(proxy.getId(), category, nr, hall, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public SeatingRow getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeatingRow)) return false;
      return ((ISeatingRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Seat> getSeats() throws PersistenceException{
      List<Seat> result = new ArrayList<>();
      for (ISeat i : Row_SeatSupervisor.getInstance().getSeats(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSeats(Seat arg) throws PersistenceException{
      Row_SeatSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSeats(Seat arg) throws PersistenceException{
      return Row_SeatSupervisor.getInstance().remove(this, arg);
   }
   public Category getCategory() throws PersistenceException{
      return Row_Has_CategorySupervisor.getInstance().getCategory(this).getTheObject();
   }
   public void setCategory(Category newCategory)throws PersistenceException{
      Row_Has_CategorySupervisor.getInstance().change(this, this.getCategory(), newCategory);
   }
   public Integer getNr() {
      return this.nr;
   }
   public void setNr(Integer newNr) throws PersistenceException{
      this.nr = newNr;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("SeatingRow", "nr", newNr.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Hall getHall() throws PersistenceException{
      return Hall_RowSupervisor.getInstance().getHall(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
