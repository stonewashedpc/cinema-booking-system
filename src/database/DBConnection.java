package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	final String filename = "jdbc:mysql://localhost:3306/cinemaservice?user=root";
	
	public void BuildConnection(String sqlCheck) throws SQLException {
		try (final Connection conn = DriverManager.getConnection(filename)) {
			try (final Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(sqlCheck);
			}
		}
	}
}