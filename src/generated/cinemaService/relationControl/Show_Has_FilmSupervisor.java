/**--- Generated at Sun Nov 28 22:51:00 CET 2021 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.cinemaService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Show_Has_FilmSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Show_Has_FilmSupervisor theInstance = new Show_Has_FilmSupervisor();
   private Relation<ICShow, IFilm> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Show_Has_FilmSupervisor(){
      this.elements = new Relation<>("Show_Has_Film");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Show_Has_FilmSupervisor getInstance(){return theInstance;}
   public Relation<ICShow, IFilm> getRelationData() {
      return this.elements;
   }
   public IFilm getFilm(ICShow owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ICShow owner, IFilm target) throws PersistenceException{
      IFilm targetOld = this.getFilm(owner); IFilm targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   /** Used only by service class !! **/
   public void setAlreadyPersistent(ICShow owner, IFilm target) {
      IFilm targetOld = null; IFilm targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ICShow owner, IFilm targetOld, IFilm targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
