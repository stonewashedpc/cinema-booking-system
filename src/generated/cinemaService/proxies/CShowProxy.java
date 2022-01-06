/**--- Generated at Thu Jan 06 20:07:30 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.CShow;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.Reservation;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.cinemaService.Film;
import generated.cinemaService.relationControl.Show_Has_FilmSupervisor;
import generated.cinemaService.Hall;
import generated.cinemaService.relationControl.Show_HallSupervisor;
public class CShowProxy implements ICShow{
   private Integer id;
   private Optional<CShow> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public CShowProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public CShowProxy(CShow theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public CShow getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "CShow";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICShow)) return false;
      return ((ICShow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private CShow load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("CShow", this.id);
         Film film = Show_Has_FilmSupervisor.getInstance().getFilm(this).getTheObject();
         Boolean reservable = rs.get().getBoolean("reservable");
         Hall hall = Show_HallSupervisor.getInstance().getHall(this).getTheObject();
         return CShow.instantiateRuntimeCopy(this, film, reservable, hall);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Reservation> getReservations() throws PersistenceException{
      return this.getTheObject().getReservations();
   }
   public void addToReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToReservations(arg);
   }
   public boolean removeFromReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromReservations(arg);
   }
   public Film getFilm() throws PersistenceException{
      return this.getTheObject().getFilm();
   }
   public void setFilm(Film newFilm)throws PersistenceException{
      this.getTheObject().setFilm(newFilm);
   }
   public Boolean getReservable() {
      return this.getTheObject().getReservable();
   }
   public void setReservable(Boolean newReservable) throws PersistenceException{
      this.getTheObject().setReservable(newReservable);
   }
   public Hall getHall() throws PersistenceException{
      return this.getTheObject().getHall();
   }
}
