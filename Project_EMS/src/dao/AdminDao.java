package dao;

import java.sql.*;
import java.util.*;
import dbc.*;
import model.*;

public class AdminDao {
	// CRUD of employee
	public static void addEmployee(Employee employee) {
		// add a new employee
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee (eid, ename, address, phonenum, email, imgpath, joindate, salary, manager, ismanager, password) values (emp_incre.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, employee.geteName());
			ps.setString(2, employee.getAddress());
			ps.setString(3, employee.getPhoneNum());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getImgPath());
			ps.setDate(6, new java.sql.Date(employee.getJoinDate().getTime()));
			ps.setDouble(7, employee.getSalary());
			ps.setInt(8, employee.getManager());
			ps.setInt(9, employee.getIsManager());
			ps.setString(10, employee.getPassword());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public static void deleteEmployee(int eid) {
		// delete employee whose ID = EID
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from employee where eid=?");
			ps.setInt(1, eid);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public static void updateEmployee(int upid) {
		// update employee information, find the targets in Employee table, 
		// and delete the record in updateReq
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from updatereq where upid=?");
			ps.setInt(1, upid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("update employee set ename=?, password=?, address=?, phonenum=?, imgpath=? where eid=?");
				ps2.setString(1, rs.getString("ename"));
				ps2.setString(2, rs.getString("password"));
				ps2.setString(3, rs.getString("address"));
				ps2.setString(4, rs.getString("phonenum"));
				ps2.setString(5, rs.getString("imgpath"));
				ps2.setInt(6, rs.getInt("eid"));
				ps2.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public static ArrayList<UpdateReq> getUpdateReqs() {
		// get list of all update requests
		Connection conn = DBconn.getConn();
		ArrayList<UpdateReq> result = new ArrayList<UpdateReq>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from updatereq");
			while (rs.next()) {
				UpdateReq upr = new UpdateReq();
				upr.setEid(rs.getInt("eid"));
				upr.setAddress(rs.getString("address"));
				upr.seteName(rs.getString("eName"));
				upr.setImgPath(rs.getString("imgpath"));
				upr.setPassword(rs.getString("password"));
				upr.setPhoneNum(rs.getString("phonenum"));
				upr.setUpid(rs.getInt("upid"));
				result.add(upr);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
	
	public static void deleteUpdateReq(int upid) {
		// delete the specified update request
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from updatereq where upid=?");
			ps.setInt(1, upid);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public static ArrayList<Employee> getAllEmployees() {
		// get list of all employees
		Connection conn = DBconn.getConn();
		ArrayList<Employee> result = new ArrayList<Employee>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
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
	
	public static Employee getEmployeeById(int eid) {
		// get the specified employee
		Connection conn = DBconn.getConn();
		Employee result = new Employee();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid=?");
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result.setEid(rs.getInt("eid"));
				result.setAddress(rs.getString("address"));
				result.setEmail(rs.getString("email"));
				result.seteName(rs.getString("ename"));
				result.setImgPath(rs.getString("imgpath"));
				result.setIsManager(rs.getInt("ismanager"));
				result.setJoinDate(rs.getDate("joindate"));
				result.setManager(rs.getInt("manager"));
				result.setPassword(rs.getString("password"));
				result.setPhoneNum(rs.getString("phonenum"));
				result.setSalary(rs.getDouble("salary"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
	
	public static Employee getEmployeeByEmail(String email) {
		// get the specified employee by email address
		Connection conn = DBconn.getConn();
		Employee result = new Employee();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result.setEid(rs.getInt("eid"));
				result.setAddress(rs.getString("address"));
				result.setEmail(rs.getString("email"));
				result.seteName(rs.getString("ename"));
				result.setImgPath(rs.getString("imgpath"));
				result.setIsManager(rs.getInt("ismanager"));
				result.setJoinDate(rs.getDate("joindate"));
				result.setManager(rs.getInt("manager"));
				result.setPassword(rs.getString("password"));
				result.setPhoneNum(rs.getString("phonenum"));
				result.setSalary(rs.getDouble("salary"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
	
	// CRUD of department
	public static void addDepartment(Department department) {
		// add new department
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into department (did, dname) values (dpt_incre.nextval, ?)");
			ps.setString(1, department.getdName());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public static void deleteDepartment(int did) {
		// delete department which ID = DID
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from department where did=?");
			ps.setInt(1, did);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public static void updateDepartment(Department department) {
		// update the specified department
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update department set dname=? where did=?");
			ps.setString(1, department.getdName());
			ps.setInt(2, department.getDid());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public static ArrayList<Department> getAllDepartments() {
		// get list of all Departments
		Connection conn = DBconn.getConn();
		ArrayList<Department> result = new ArrayList<Department>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from department");
			while (rs.next()) {
				Department dpt = new Department();
				dpt.setDid(rs.getInt("did"));
				dpt.setdName(rs.getString("dname"));
				result.add(dpt);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
	
	public static Department getDepartmentById(int did) {
		// get the specified Department
		Connection conn = DBconn.getConn();
		Department result = new Department();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from department where did=?");
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result.setDid(rs.getInt("did"));
				result.setdName(rs.getString("dname"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
		return result;
	}
	
	// associate designation
	public static void designAssociate(int eid, int did) {
		// which means insert a new record in empdpt table
		Connection conn = DBconn.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into empdpt (edid, eid, did) values (ed_incre.nextval, ?, ?)");
			ps.setInt(1, eid);
			ps.setInt(2, did);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
}
