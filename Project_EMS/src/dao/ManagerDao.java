package dao;

import java.sql.*;
import java.util.*;

import dbc.*;
import model.*;

public class ManagerDao {
	// constructor, create new connection
	private Connection conn;
	public ManagerDao() {
		conn = DBconn.getConn();
	}
	
	public boolean isManagerOrNot(Employee employee) {
		// decide whether the current employee is manager
		boolean result = false;
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
	
	public ArrayList<Employee> getReportList() {
		// get list of manager's employee
		ArrayList<Employee> result = new ArrayList<Employee>();
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
}
