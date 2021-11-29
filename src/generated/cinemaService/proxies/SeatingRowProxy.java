/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.SeatingRow;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.Seat;
import java.util.List;
import generated.cinemaService.Category;
import generated.cinemaService.relationControl.Row_Has_CategorySupervisor;
import generated.cinemaService.Hall;
import generated.cinemaService.relationControl.Hall_RowSupervisor;
public class SeatingRowProxy implements ISeatingRow{
   private Integer id;
   private Optional<SeatingRow> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public SeatingRowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public SeatingRowProxy(SeatingRow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public SeatingRow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "SeatingRow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ISeatingRow)) return false;
      return ((ISeatingRow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private SeatingRow load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("SeatingRow", this.id);
         Category category = Row_Has_CategorySupervisor.getInstance().getCategory(this).getTheObject();
         Integer nr = rs.get().getInt("nr");
         Hall hall = Hall_RowSupervisor.getInstance().getHall(this).getTheObject();
         return SeatingRow.instantiateRuntimeCopy(this, category, nr, hall);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Seat> getSeats() throws PersistenceException{
      return this.getTheObject().getSeats();
   }
   public void addToSeats(Seat arg) throws PersistenceException{
      this.getTheObject().addToSeats(arg);
   }
   public boolean removeFromSeats(Seat arg) throws PersistenceException{
      return this.getTheObject().removeFromSeats(arg);
   }
   public Category getCategory() throws PersistenceException{
      return this.getTheObject().getCategory();
   }
   public void setCategory(Category newCategory)throws PersistenceException{
      this.getTheObject().setCategory(newCategory);
   }
   public Integer getNr() {
      return this.getTheObject().getNr();
   }
   public void setNr(Integer newNr) throws PersistenceException{
      this.getTheObject().setNr(newNr);
   }
   public Hall getHall() throws PersistenceException{
      return this.getTheObject().getHall();
   }
}
