/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
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
import java.util.Set;
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
         return Seat.instantiateRuntimeCopy(this, nr);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Integer getNr() {
      return this.getTheObject().getNr();
   }
   public void setNr(Integer newNr) throws PersistenceException{
      this.getTheObject().setNr(newNr);
   }
   public Set<SeatingRow> getRow() throws PersistenceException{
      return this.getTheObject().getRow();
   }
}
