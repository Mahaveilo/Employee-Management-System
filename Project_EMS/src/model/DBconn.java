package model;

import java.sql.*;

public class DBconn {
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
	
	public static Statement getStatement(Connection conn) {
		Statement st = null;
		try {
			if(conn != null)
				st = conn.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public static ResultSet getResultSet(Statement st, String sql) {
		ResultSet rs = null;
		try {
			if(st != null)
				rs = st.executeQuery(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void closeConn(Connection conn) {
		try {
			if(conn != null)
				conn.close();
			conn = null;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
