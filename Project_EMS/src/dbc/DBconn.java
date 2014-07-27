package dbc;

import java.sql.*;

public class DBconn {
	// open connection
	public static Connection getConn() {
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); // load driver, type 4 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "371825469");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	// close connection
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
