package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import dao.*;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao aDao = new AdminDao();
		Employee emp = new Employee();
		emp.seteName(request.getParameter("ename"));
		emp.setAddress(request.getParameter("add"));
		emp.setEmail(request.getParameter("email"));
		emp.setPassword(request.getParameter("pwd"));
		emp.setPhoneNum(request.getParameter("phone"));
		emp.setIsManager(Integer.parseInt(request.getParameter("ismanager")));
		emp.setSalary(Double.parseDouble(request.getParameter("salary")));
		emp.setManager(Integer.parseInt(request.getParameter("manager")));
		emp.setJoinDate(new Date());
		emp.setImgPath("null");
		aDao.addEmployee(emp);
		response.sendRedirect("admin.jsp");
	}

}
