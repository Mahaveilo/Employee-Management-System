package dao;

import java.sql.*;
import java.util.*;

import dbc.*;
import model.*;

public class ManagerDao {
	// manager dao class
	public static boolean isManagerOrNot(Employee employee) {
		// decide whether the current employee is manager
		Connection conn = DBconn.getConn();
		boolean result = false;
		try {
			int eid = employee.getEid();
			PreparedStatement ps = conn.prepareStatement("select ismanager from employee where eid=?");
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if(rs.getInt("ismanager") == 1)
					result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
	
	public static ArrayList<Employee> getReportList(Employee manager) {
		// get list of manager's employee
		Connection conn = DBconn.getConn();
		ArrayList<Employee> result = new ArrayList<Employee>();
		int managerID = manager.getEid();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee where manager=?");
			ps.setInt(1, managerID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEid(rs.getInt("eid"));
				emp.setAddress(rs.getString("address"));
				emp.setEmail(rs.getString("email"));
				emp.seteName(rs.getString("eName"));
				emp.setImgPath(rs.getString("imgpath"));
				emp.setIsManager(rs.getInt("ismanager"));
				emp.setJoinDate(rs.getDate("joindate"));
				emp.setManager(rs.getInt("manager"));
				emp.setPassword(rs.getString("password"));
				emp.setPhoneNum(rs.getString("phonenum"));
				emp.setSalary(rs.getDouble("salary"));
				result.add(emp);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
}
