package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetDB {

	final String dbResetQuerryForTest = "SET FOREIGN_KEY_CHECKS = 0;" 
									+ "TRUNCATE TABLE user_has_role;"
									+ "TRUNCATE TABLE user_has_password;"
									+ "TRUNCATE TABLE user_reservation;"
									+ "TRUNCATE TABLE show_has_film;"
									+ "TRUNCATE TABLE show_hall;"
									+ "TRUNCATE TABLE row_seat;"
									+ "TRUNCATE TABLE row_has_category;"
									+ "TRUNCATE TABLE reservation_show;"
									+ "TRUNCATE TABLE reservation_seat;"
									+ "TRUNCATE TABLE hall_row;"
									+ "TRUNCATE TABLE booking_for_reservation;"
									+ "TRUNCATE TABLE user;"
									+ "TRUNCATE TABLE seatingrow;"
									+ "TRUNCATE TABLE seat;"
									+ "TRUNCATE TABLE reservation;"
									+ "TRUNCATE TABLE password;"
									+ "TRUNCATE TABLE hall;"
									+ "TRUNCATE TABLE film;"
									+ "TRUNCATE TABLE cshow;"
									+ "TRUNCATE TABLE booking;"
									+ "SET FOREIGN_KEY_CHECKS = 1;";
	
	private DBConnection dbConnection;
	private Connection conn;

	public void resestDBForTest() throws SQLException {
		dbConnection = new DBConnection();
		conn = dbConnection.creatConnection();
		final Statement stmt = conn.createStatement();
		for(String str: dbResetQuerryForTest.split(";")) stmt.addBatch(str);
		stmt.executeBatch();
	}
}
