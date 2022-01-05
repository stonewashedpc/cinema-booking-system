package database;

import java.sql.SQLException;

public class ResetDB {

	final String sqlCheck = "TRUNCATE TABLE user_has_password";
	private DBConnection conn;
	
	public void resetDB() throws SQLException {  
		conn = new DBConnection();
		conn.BuildConnection(sqlCheck);
	}

}
