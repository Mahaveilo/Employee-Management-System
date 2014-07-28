package dao;

import java.sql.*;
import java.util.*;
import dbc.*;
import model.*;

public class AdminDao {
	// constructor, create new connection
	private Connection conn;
	public AdminDao() {
		conn = DBconn.getConn();
	}
	
	// CRUD of employee
	public void addEmployee(Employee employee) {
		// add a new employee
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee (ename, address, phonenum, email, imgpath, joindate, salary, manager, ismanager, password) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
	
	public void deleteEmployee(int eid) {
		// delete employee whose ID = EID
		try {
			PreparedStatement ps = conn.prepareStatement("delete from emloyee where eid=?");
			ps.setInt(1, eid);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public void updateEmployee(UpdateReq updateReq) {
		// update employee information, find the targets in Employee table, 
		// and delete the record in updateReq
		try {
			PreparedStatement ps = conn.prepareStatement("update employee set ename=?, password=?, address=?, phonenum=?, imgpath=? where eid=?");
			ps.setString(1, updateReq.geteName());
			ps.setString(2, updateReq.getPassword());
			ps.setString(3, updateReq.getAddress());
			ps.setString(4, updateReq.getPhoneNum());
			ps.setString(5, updateReq.getImgPath());
			ps.setInt(6, updateReq.getEid());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public ArrayList<Employee> getAllEmployees() {
		// get list of all employees
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
	
	public Employee getEmployeeById(int eid) {
		// get the specified employee
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
	
	// CRUD of department
	public void addDepartment(Department department) {
		// add new department
		try {
			PreparedStatement ps = conn.prepareStatement("insert into department (dname) values (?)");
			ps.setString(1, department.getdName());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public void deleteDepartment(int did) {
		// delete department which ID = DID
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
	
	public void updateDepartment(Department department) {
		// update the specified department
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
	
	public ArrayList<Department> getAllDepartments() {
		// get list of all Departments
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
	
	public Department getDepartmentById(int did) {
		// get the specified Department
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
	public void designAssociate(int eid, int did) {
		// which means insert a new record in empdpt table
		try {
			PreparedStatement ps = conn.prepareStatement("insert into empdpt (eid, did) values (?, ?)");
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
