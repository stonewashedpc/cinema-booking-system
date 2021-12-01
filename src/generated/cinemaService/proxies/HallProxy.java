/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Hall;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.CShow;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.cinemaService.SeatingRow;
public class HallProxy implements IHall{
   private Integer id;
   private Optional<Hall> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public HallProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public HallProxy(Hall theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Hall getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Hall";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IHall)) return false;
      return ((IHall)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Hall load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Hall", this.id);
         String name = rs.get().getString("name");
         return Hall.instantiateRuntimeCopy(this, name);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<CShow> getShow() throws PersistenceException{
      return this.getTheObject().getShow();
   }
   public void addToShow(CShow arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToShow(arg);
   }
   public boolean removeFromShow(CShow arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromShow(arg);
   }
   public List<SeatingRow> getRows() throws PersistenceException{
      return this.getTheObject().getRows();
   }
   public void addToRows(SeatingRow arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToRows(arg);
   }
   public boolean removeFromRows(SeatingRow arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromRows(arg);
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
}
