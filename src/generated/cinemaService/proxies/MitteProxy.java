/**--- Generated at Thu Nov 18 14:34:02 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Mitte;
import java.sql.ResultSet;
import java.util.Optional;
public class MitteProxy implements IMitte{
   private Integer id;
   private Optional<Mitte> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public MitteProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public MitteProxy(Mitte theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Mitte getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Mitte";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IMitte)) return false;
      return ((IMitte)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Mitte load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Mitte", this.id);
         return Mitte.instantiateRuntimeCopy(this);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public void stornieren(){
      this.getTheObject().stornieren();
   }
}
