/**--- Generated at Sat Jan 08 20:20:38 CET 2022 
 * --- No Change Allowed!  
 */
package generated.cinemaService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.cinemaService.Seat;
import generated.cinemaService.SeatingRow;
public interface ISeat extends Identifiable{
   public Seat getTheObject();
   public Integer getId();
   public Integer getNr() ;
   public void setNr(Integer newNr) throws PersistenceException;
   public SeatingRow getRow() throws PersistenceException;
}
