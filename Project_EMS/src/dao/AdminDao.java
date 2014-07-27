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
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public void deleteEmployee(int eid) {
		// delete employee whose ID = EID
		try {
			
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
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public void deleteDepartment(int did) {
		// delete department which ID = DID
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
	
	public void updateDepartment(Department department) {
		// update the specified department
		try {
			
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
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
}
