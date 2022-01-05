package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public Connection creatConnection() throws SQLException {

		Connection conn = null;

		try {

			Properties props = new Properties();
			props.load(new FileInputStream("./src/config/DBConfiguration.properties"));
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			String dbUrl = props.getProperty("dbUrl");

			final Connection connection = DriverManager.getConnection(dbUrl, user, password);
			conn = connection;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
}