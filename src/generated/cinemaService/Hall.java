/**--- Generated at Mon Jan 10 23:02:47 CET 2022 
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
import java.util.List;
import generated.cinemaService.proxies.ICShow;
import generated.cinemaService.relationControl.Show_HallSupervisor;
import generated.cinemaService.proxies.ISeatingRow;
import generated.cinemaService.relationControl.Hall_RowSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.HallProxy;
import observation.Observable;
import generated.cinemaService.proxies.IHall;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Hall extends Observable implements java.io.Serializable, IHall
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Hall(Integer id, String name, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      if(objectOnly) return;
   }
   public static Hall createFresh(String name)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Hall", "id, typeKey, name", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Hall").toString() + ", " + "'" + name + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Hall me = new Hall(id, name, false);
      CinemaService.getInstance().addHallProxy(new HallProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getHallCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Hall toBeDeleted = CinemaService.getInstance().getHall(id);
      List<ICShow> targetsInShow_Hall = Show_HallSupervisor.getInstance().getRelationData().getRelatedTargets(toBeDeleted);
      if(targetsInShow_Hall.size()>0) throw new ConstraintViolation(" Deletion not possible: Object still contains other objects in Association Show_Hall");
      Show_HallSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      List<ISeatingRow> targetsInHall_Row = Hall_RowSupervisor.getInstance().getRelationData().getRelatedTargets(toBeDeleted);
      if(targetsInHall_Row.size()>0) throw new ConstraintViolation(" Deletion not possible: Object still contains other objects in Association Hall_Row");
      Hall_RowSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      CinemaService.getInstance().getHallCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Hall", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Hall instantiateRuntimeCopy(HallProxy proxy, String name){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Hall(proxy.getId(), name, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Hall getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IHall)) return false;
      return ((IHall)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<CShow> getShow() throws PersistenceException{
      List<CShow> result = new ArrayList<>();
      for (ICShow i : Show_HallSupervisor.getInstance().getShow(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToShow(CShow arg) throws ConstraintViolation, PersistenceException{
      Show_HallSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromShow(CShow arg) throws ConstraintViolation, PersistenceException{
      return Show_HallSupervisor.getInstance().remove(this, arg);
   }
   public List<SeatingRow> getRows() throws PersistenceException{
      List<SeatingRow> result = new ArrayList<>();
      for (ISeatingRow i : Hall_RowSupervisor.getInstance().getRows(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToRows(SeatingRow arg) throws ConstraintViolation, PersistenceException{
      Hall_RowSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromRows(SeatingRow arg) throws ConstraintViolation, PersistenceException{
      return Hall_RowSupervisor.getInstance().remove(this, arg);
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Hall", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
/**
 * @throws ConstraintViolation 
 * @throws PersistenceException 
 * 
 */
   public void removeShow(CShow show) throws PersistenceException, ConstraintViolation{
      this.removeFromShow(show);
   }
/**
 * 
 */
   public CShow addShow(Film film){
      return CShow.createFresh(film, false, this);
   }
//90 ===== GENERATED: End of Your Operations ======
}
