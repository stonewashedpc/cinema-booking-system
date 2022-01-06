/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
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
import generated.cinemaService.relationControl.Reservation_SeatSupervisor;
import generated.cinemaService.relationControl.Row_SeatSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.SeatProxy;
import observation.Observable;
import generated.cinemaService.proxies.ISeat;
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import java.util.Set;
import java.util.HashSet;
import generated.cinemaService.proxies.ISeatingRow;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Seat extends Observable implements java.io.Serializable, ISeat
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Integer nr;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Seat(Integer id, Integer nr, SeatingRow row, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      this.nr = nr;
      if(objectOnly) return;
      try{Row_SeatSupervisor.getInstance().add(row,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static Seat createFresh(Integer nr, SeatingRow row)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Seat", "id, typeKey, nr", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Seat").toString() + ", " + nr.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Seat me = new Seat(id, nr, row, false);
      CinemaService.getInstance().addSeatProxy(new SeatProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getSeatCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Seat toBeDeleted = CinemaService.getInstance().getSeat(id);
      Reservation_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      Row_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      CinemaService.getInstance().getSeatCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Seat", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Seat instantiateRuntimeCopy(SeatProxy proxy, Integer nr, SeatingRow row)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Seat(proxy.getId(), nr, row, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Seat getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeat)) return false;
      return ((ISeat)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Integer getNr() {
      return this.nr;
   }
   public void setNr(Integer newNr) throws PersistenceException{
      this.nr = newNr;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Seat", "nr", newNr.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public SeatingRow getRow() throws PersistenceException{
      return Row_SeatSupervisor.getInstance().getRow(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public Integer getPrice(){
      return this.getRow().getCategory().getPrice().orElse(0);
   }
//90 ===== GENERATED: End of Your Operations ======
}
