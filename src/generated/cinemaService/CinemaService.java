/**--- Generated at Thu Nov 18 14:34:01 CET 2021 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.cinemaService;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.cinemaService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.cinemaService.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceDMLExecuter;
import db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class CinemaService extends Observable{
   private PersistenceDMLExecuter dmlExecuter;
   private Map<Integer,UserProxy> userCache;
   private Map<Integer,PasswordProxy> passwordCache;
   private Map<Integer,ReservationProxy> reservationCache;
   private Map<Integer,BookingProxy> bookingCache;
   private Map<Integer,MitteProxy> mitteCache;
   private Map<Integer,CShowProxy> cShowCache;
   private Map<Integer,FilmProxy> filmCache;
   private Map<Integer,HallProxy> hallCache;
   private Map<Integer,SeatingRowProxy> seatingRowCache;
   private Map<Integer,SeatProxy> seatCache;
   private static CinemaService theInstance = new CinemaService();
   private CinemaService(){
      PersistenceExecuterFactory.setUseDataBase();
      this.dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().openDBConnection(new DBConnectionData("jdbc:mysql://localhost:3306", "CinemaService", "root" , ""));
         PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().initializeFor("CinemaService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static CinemaService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.userCache = new InitialProxyLoader<UserProxy>("generated", "CinemaService", "cinemaService", "User", "User").perform();
      this.passwordCache = new InitialProxyLoader<PasswordProxy>("generated", "CinemaService", "cinemaService", "Password", "Password").perform();
      this.reservationCache = new InitialProxyLoader<ReservationProxy>("generated", "CinemaService", "cinemaService", "Reservation", "Reservation").perform();
      this.bookingCache = new InitialProxyLoader<BookingProxy>("generated", "CinemaService", "cinemaService", "Booking", "Booking").perform();
      this.mitteCache = new InitialProxyLoader<MitteProxy>("generated", "CinemaService", "cinemaService", "Mitte", "Mitte").perform();
      this.cShowCache = new InitialProxyLoader<CShowProxy>("generated", "CinemaService", "cinemaService", "CShow", "CShow").perform();
      this.filmCache = new InitialProxyLoader<FilmProxy>("generated", "CinemaService", "cinemaService", "Film", "Film").perform();
      this.hallCache = new InitialProxyLoader<HallProxy>("generated", "CinemaService", "cinemaService", "Hall", "Hall").perform();
      this.seatingRowCache = new InitialProxyLoader<SeatingRowProxy>("generated", "CinemaService", "cinemaService", "SeatingRow", "SeatingRow").perform();
      this.seatCache = new InitialProxyLoader<SeatProxy>("generated", "CinemaService", "cinemaService", "Seat", "Seat").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("User_Has_Password").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "User", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Password", "CinemaService");
         try{this.addUser_Has_PasswordElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("User_Has_Role").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "User", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Role", "CinemaService");
         try{this.addUser_Has_RoleElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("User_Reservation").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "User", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Reservation", "CinemaService");
         try{this.addUser_ReservationElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Booking_For_Reservation").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Booking", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Reservation", "CinemaService");
         try{this.addBooking_For_ReservationElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Reservation_Show").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "CShow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Reservation", "CinemaService");
         try{this.addReservation_ShowElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Reservation_Seat").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addReservation_SeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Show_Hall").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Hall", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "CShow", "CinemaService");
         try{this.addShow_HallElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Show_Has_Film").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "CShow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Film", "CinemaService");
         try{this.addShow_Has_FilmElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Hall_Row").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Hall", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "SeatingRow", "CinemaService");
         try{this.addHall_RowElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Row_Seat").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "SeatingRow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat", "CinemaService");
         try{this.addRow_SeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("Row_Has_Category").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "SeatingRow", "CinemaService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Category", "CinemaService");
         try{this.addRow_Has_CategoryElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addUser_Has_PasswordElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IUser proxy1 = null; IPassword proxy2 = null; 
      if(className1.equals("User"))  proxy1 = this.userCache.get(id1);
      if(className2.equals("Password"))  proxy2 = this.passwordCache.get(id2);
      User_Has_PasswordSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addUser_Has_RoleElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IUser proxy1 = null; IRole proxy2 = null; 
      if(className1.equals("User"))  proxy1 = this.userCache.get(id1);
      if(className2.equals("Customer"))  proxy2 = Customer.getInstance();
      if(className2.equals("Owner"))  proxy2 = Owner.getInstance();
      User_Has_RoleSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addUser_ReservationElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IUser proxy1 = null; IReservation proxy2 = null; 
      if(className1.equals("User"))  proxy1 = this.userCache.get(id1);
      if(className2.equals("Reservation"))  proxy2 = this.reservationCache.get(id2);
      User_ReservationSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addBooking_For_ReservationElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBooking proxy1 = null; IReservation proxy2 = null; 
      if(className2.equals("Reservation"))  proxy2 = this.reservationCache.get(id2);
      if(className1.equals("Booking"))  proxy1 = this.bookingCache.get(id1);
      Booking_For_ReservationSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addReservation_ShowElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICShow proxy1 = null; IReservation proxy2 = null; 
      if(className2.equals("Reservation"))  proxy2 = this.reservationCache.get(id2);
      if(className1.equals("CShow"))  proxy1 = this.cShowCache.get(id1);
      Reservation_ShowSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addReservation_SeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; ISeat proxy2 = null; 
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      Reservation_SeatSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addShow_HallElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IHall proxy1 = null; ICShow proxy2 = null; 
      if(className2.equals("CShow"))  proxy2 = this.cShowCache.get(id2);
      if(className1.equals("Hall"))  proxy1 = this.hallCache.get(id1);
      Show_HallSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addShow_Has_FilmElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICShow proxy1 = null; IFilm proxy2 = null; 
      if(className1.equals("CShow"))  proxy1 = this.cShowCache.get(id1);
      if(className2.equals("Film"))  proxy2 = this.filmCache.get(id2);
      Show_Has_FilmSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addHall_RowElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IHall proxy1 = null; ISeatingRow proxy2 = null; 
      if(className1.equals("Hall"))  proxy1 = this.hallCache.get(id1);
      if(className2.equals("SeatingRow"))  proxy2 = this.seatingRowCache.get(id2);
      Hall_RowSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addRow_SeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ISeatingRow proxy1 = null; ISeat proxy2 = null; 
      if(className1.equals("SeatingRow"))  proxy1 = this.seatingRowCache.get(id1);
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      Row_SeatSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addRow_Has_CategoryElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ISeatingRow proxy1 = null; ICategory proxy2 = null; 
      if(className1.equals("SeatingRow"))  proxy1 = this.seatingRowCache.get(id1);
      if(className2.equals("Parterre"))  proxy2 = Parterre.getInstance();
      if(className2.equals("Middle"))  proxy2 = Middle.getInstance();
      if(className2.equals("Back"))  proxy2 = Back.getInstance();
      Row_Has_CategorySupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   public User getUser(Integer id){
      return this.userCache.get(id).getTheObject();
   }
   public void addUserProxy(UserProxy p) throws PersistenceException{
      this.userCache.put(p.getId(), p);
   }
   public Map<Integer,UserProxy> getUserCache(){
      return this.userCache;
   }
   public Password getPassword(Integer id){
      return this.passwordCache.get(id).getTheObject();
   }
   public void addPasswordProxy(PasswordProxy p) throws PersistenceException{
      this.passwordCache.put(p.getId(), p);
   }
   public Map<Integer,PasswordProxy> getPasswordCache(){
      return this.passwordCache;
   }
   public Reservation getReservation(Integer id){
      return this.reservationCache.get(id).getTheObject();
   }
   public void addReservationProxy(ReservationProxy p) throws PersistenceException{
      this.reservationCache.put(p.getId(), p);
   }
   public Map<Integer,ReservationProxy> getReservationCache(){
      return this.reservationCache;
   }
   public Booking getBooking(Integer id){
      return this.bookingCache.get(id).getTheObject();
   }
   public void addBookingProxy(BookingProxy p) throws PersistenceException{
      this.bookingCache.put(p.getId(), p);
   }
   public Map<Integer,BookingProxy> getBookingCache(){
      return this.bookingCache;
   }
   public Mitte getMitte(Integer id){
      return this.mitteCache.get(id).getTheObject();
   }
   public void addMitteProxy(MitteProxy p) throws PersistenceException{
      this.mitteCache.put(p.getId(), p);
   }
   public Map<Integer,MitteProxy> getMitteCache(){
      return this.mitteCache;
   }
   public CShow getCShow(Integer id){
      return this.cShowCache.get(id).getTheObject();
   }
   public void addCShowProxy(CShowProxy p) throws PersistenceException{
      this.cShowCache.put(p.getId(), p);
   }
   public Map<Integer,CShowProxy> getCShowCache(){
      return this.cShowCache;
   }
   public Film getFilm(Integer id){
      return this.filmCache.get(id).getTheObject();
   }
   public void addFilmProxy(FilmProxy p) throws PersistenceException{
      this.filmCache.put(p.getId(), p);
   }
   public Map<Integer,FilmProxy> getFilmCache(){
      return this.filmCache;
   }
   public Hall getHall(Integer id){
      return this.hallCache.get(id).getTheObject();
   }
   public void addHallProxy(HallProxy p) throws PersistenceException{
      this.hallCache.put(p.getId(), p);
   }
   public Map<Integer,HallProxy> getHallCache(){
      return this.hallCache;
   }
   public SeatingRow getSeatingRow(Integer id){
      return this.seatingRowCache.get(id).getTheObject();
   }
   public void addSeatingRowProxy(SeatingRowProxy p) throws PersistenceException{
      this.seatingRowCache.put(p.getId(), p);
   }
   public Map<Integer,SeatingRowProxy> getSeatingRowCache(){
      return this.seatingRowCache;
   }
   public Seat getSeat(Integer id){
      return this.seatCache.get(id).getTheObject();
   }
   public void addSeatProxy(SeatProxy p) throws PersistenceException{
      this.seatCache.put(p.getId(), p);
   }
   public Map<Integer,SeatProxy> getSeatCache(){
      return this.seatCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().closeConnection();
   }
   //80 ===== Editable : Your Operations =============
/**
 * 
 */
   public void removeFilm(Film film){
      // TODO: Implement Operation removeFilm
      return;
   }
/**
 * 
 */
   public User register(String name, String password){
      // TODO: Implement Operation register
      return null;
   }
/**
 * 
 */
   public void removeHall(Hall hall){
      // TODO: Implement Operation removeHall
      return;
   }
/**
 * 
 */
   public Film addFilm(String name){
      // TODO: Implement Operation addFilm
      return null;
   }
/**
 * 
 */
   public User register(String name, String password, Role role){
      // TODO: Implement Operation register
      return null;
   }
/**
 * 
 */
   public void unregister(User user){
      // TODO: Implement Operation unregister
      return;
   }
/**
 * 
 */
   public Hall addHall(String name){
      // TODO: Implement Operation addHall
      return null;
   }
/**
 * 
 */
   public Reservation reserve(User user, Seat seat, CShow show){
      // TODO: Implement Operation reserve
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
