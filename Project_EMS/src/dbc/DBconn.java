package dbc;

import java.sql.*;

public class DBconn {
	//generate connection
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
	
	//generate statement
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
	
	//get result set by execute "sql", overloaded method
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
	public static ResultSet getResultSet(Connection conn, String sql) {
		Statement st = getStatement(conn);
		ResultSet rs = getResultSet(st, sql);
		close(st);
		return rs;
	}
	
	// overload close() method
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
	public static void close(Statement st) {
		try {
			if(st != null) {
				st.close();
				st = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
