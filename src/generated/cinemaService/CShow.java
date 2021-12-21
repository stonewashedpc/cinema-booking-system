/**--- Generated at Tue Dec 21 20:30:54 CET 2021 
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
import generated.cinemaService.relationControl.Show_HallSupervisor;
import java.util.List;
import java.util.stream.Collectors;

import generated.cinemaService.proxies.IReservation;
import generated.cinemaService.relationControl.Reservation_ShowSupervisor;
import generated.cinemaService.relationControl.Show_Has_FilmSupervisor;
import db.executer.PersistenceExecuterFactory;
import generated.cinemaService.proxies.CShowProxy;
import observation.Observable;
import generated.cinemaService.proxies.ICShow;
import generated.cinemaService.relationControl.*;
import generated.cinemaService.proxies.*;
import db.executer.PersistenceException;
import java.util.ArrayList;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class CShow extends Observable implements java.io.Serializable, ICShow
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Boolean reservable;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private CShow(Integer id, Film film, Boolean reservable, Hall hall, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      Show_Has_FilmSupervisor.getInstance().set(this, film);
      this.reservable = reservable;
      if(objectOnly) return;
      try{Show_HallSupervisor.getInstance().add(hall,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   public static CShow createFresh(Film film, Boolean reservable, Hall hall)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("CShow", "id, typeKey, reservable", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("CinemaService", "CShow").toString() + ", " + reservable.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      CShow me = new CShow(id, film, reservable, hall, false);
      CinemaService.getInstance().addCShowProxy(new CShowProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!CinemaService.getInstance().getCShowCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      CShow toBeDeleted = CinemaService.getInstance().getCShow(id);
      Show_HallSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      List<IReservation> targetsInReservation_Show = Reservation_ShowSupervisor.getInstance().getRelationData().getRelatedTargets(toBeDeleted);
      if(targetsInReservation_Show.size()>0) throw new ConstraintViolation(" Deletion not possible: Object still contains other objects in Association Reservation_Show");
      Reservation_ShowSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      Show_Has_FilmSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      CinemaService.getInstance().getCShowCache().remove(id);
      PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().delete("CShow", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static CShow instantiateRuntimeCopy(CShowProxy proxy, Film film, Boolean reservable, Hall hall)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new CShow(proxy.getId(), film, reservable, hall, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public CShow getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ICShow)) return false;
      return ((ICShow)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public List<Reservation> getReservations() throws PersistenceException{
      List<Reservation> result = new ArrayList<>();
      for (IReservation i : Reservation_ShowSupervisor.getInstance().getReservations(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      Reservation_ShowSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromReservations(Reservation arg) throws ConstraintViolation, PersistenceException{
      return Reservation_ShowSupervisor.getInstance().remove(this, arg);
   }
   public Film getFilm() throws PersistenceException{
      return Show_Has_FilmSupervisor.getInstance().getFilm(this).getTheObject();
   }
   public void setFilm(Film newFilm)throws PersistenceException{
      Show_Has_FilmSupervisor.getInstance().change(this, this.getFilm(), newFilm);
   }
   public Boolean getReservable() {
      return this.reservable;
   }
   public void setReservable(Boolean newReservable) throws PersistenceException{
      this.reservable = newReservable;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("CShow", "reservable", newReservable.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Hall getHall() throws PersistenceException{
      return Show_HallSupervisor.getInstance().getHall(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public Integer calculateTotalIncome(){
	   List<Reservation> bookedReservations = this.getReservations().stream().filter(r -> r.getBooking() != null).collect(Collectors.toList());
	   return bookedReservations.stream().mapToInt(r -> r.getSeat().stream().mapToInt(seat -> seat.getRow().getCategory().getPrice().get()).sum()).sum();
   }
/**
 * 
 */
   public void setOpenForReservations(){
      this.setReservable(true);
   }
//90 ===== GENERATED: End of Your Operations ======
}
