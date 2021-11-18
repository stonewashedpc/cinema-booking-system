/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
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
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.MitteProxy;
import observation.Observable;
import generated.cinemaService.proxies.IMitte;
import db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Mitte extends Observable implements java.io.Serializable, IMitte
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Mitte(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
      if(objectOnly) return;
   }
   public static Mitte createFresh()throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Mitte", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Mitte").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Mitte me = new Mitte(id, false);
      CinemaService.getInstance().addMitteProxy(new MitteProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getMitteCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Mitte toBeDeleted = CinemaService.getInstance().getMitte(id);
      CinemaService.getInstance().getMitteCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Mitte", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Mitte instantiateRuntimeCopy(MitteProxy proxy){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Mitte(proxy.getId(), true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Mitte getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMitte)) return false;
      return ((IMitte)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public void stornieren(){
      // TODO: Implement Operation stornieren
      return;
   }
//90 ===== GENERATED: End of Your Operations ======
}
