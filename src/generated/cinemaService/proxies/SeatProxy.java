/**--- Generated at Tue Dec 21 20:30:54 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Seat;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.SeatingRow;
import generated.cinemaService.relationControl.Row_SeatSupervisor;
public class SeatProxy implements ISeat{
   private Integer id;
   private Optional<Seat> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public SeatProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public SeatProxy(Seat theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Seat getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Seat";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeat)) return false;
      return ((ISeat)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Seat load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Seat", this.id);
         Integer nr = rs.get().getInt("nr");
         SeatingRow row = Row_SeatSupervisor.getInstance().getRow(this).getTheObject();
         return Seat.instantiateRuntimeCopy(this, nr, row);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Integer getNr() {
      return this.getTheObject().getNr();
   }
   public void setNr(Integer newNr) throws PersistenceException{
      this.getTheObject().setNr(newNr);
   }
   public SeatingRow getRow() throws PersistenceException{
      return this.getTheObject().getRow();
   }
}
