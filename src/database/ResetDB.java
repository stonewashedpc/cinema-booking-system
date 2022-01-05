package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetDB {

	final String dbResetQuerryForTest = "TRUNCATE TABLE user_has_password";
	private DBConnection dbConnection;
	private Connection conn;

	public void resestDBForTest() throws SQLException {
		dbConnection = new DBConnection();
		conn = dbConnection.creatConnection();
		final Statement stmt = conn.createStatement();
		stmt.executeUpdate(dbResetQuerryForTest);
	}

}
