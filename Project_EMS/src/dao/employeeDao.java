package dao;

import java.sql.*;
import dbc.*;
import model.*;

public class EmployeeDao {
	// constructor, create new connection
	private Connection conn;
	public EmployeeDao() {
		conn = DBconn.getConn();
	}
	
	public void updateRequest(UpdateReq updateReq) {
		// generate the update information, similar as insert a new record in UpdateReq table
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
}
