/**--- Generated at Wed Dec 01 21:14:10 CET 2021 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.cinemaService.Booking;
import java.sql.ResultSet;
import java.util.Optional;
import generated.cinemaService.Reservation;
import exceptions.ConstraintViolation;
public class BookingProxy implements IBooking{
   private Integer id;
   private Optional<Booking> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public BookingProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public BookingProxy(Booking theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Booking getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Booking";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBooking)) return false;
      return ((IBooking)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Booking load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Booking", this.id);
         return Booking.instantiateRuntimeCopy(this);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Optional<Reservation> getReservation() throws PersistenceException{
      return this.getTheObject().getReservation();
   }
   public void setReservation(Reservation newReservation)throws ConstraintViolation, PersistenceException{
      this.getTheObject().setReservation(newReservation);
   }
}
