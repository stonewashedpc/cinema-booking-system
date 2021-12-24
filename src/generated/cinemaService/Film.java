/**--- Generated at Fri Dec 24 00:10:00 CET 2021 
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
import generated.cinemaService.relationControl.Show_Has_FilmSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.FilmProxy;
import observation.Observable;
import generated.cinemaService.proxies.IFilm;
import db.executer.PersistenceException;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Film extends Observable implements java.io.Serializable, IFilm
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Film(Integer id, String name, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      if(objectOnly) return;
   }
   public static Film createFresh(String name)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Film", "id, typeKey, name", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "Film").toString() + ", " + "'" + name + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Film me = new Film(id, name, false);
      CinemaService.getInstance().addFilmProxy(new FilmProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getFilmCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Film toBeDeleted = CinemaService.getInstance().getFilm(id);
      List<ICShow> ownersInShow_Has_Film = Show_Has_FilmSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInShow_Has_Film.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association Show_Has_Film");
      Show_Has_FilmSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      CinemaService.getInstance().getFilmCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("Film", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Film instantiateRuntimeCopy(FilmProxy proxy, String name){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Film(proxy.getId(), name, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Film getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFilm)) return false;
      return ((IFilm)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Film", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
