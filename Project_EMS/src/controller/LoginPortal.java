package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employee;
import dao.*;

/**
 * Servlet implementation class LoginPortal
 */
@WebServlet("/LoginPortal")
public class LoginPortal extends HttpServlet {
	// employee / manager login portal
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPortal() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(request.getParameter("managerLogin").equals("maneger")) {
			if(EmployeeDao.loginAuthentication(email, password) && ManagerDao.isManagerOrNot(email)) {
				Employee emp = new Employee();
				emp = AdminDao.getEmployeeByEmail(email);
				HttpSession session = request.getSession(true);	    
		        session.setAttribute("currentEmployee", emp);
				response.sendRedirect("manager.jsp");
			}
			else
				response.sendRedirect("login.jsp");
		}
		else if(request.getParameter("managerLogin").equals("employee")){
			if(EmployeeDao.loginAuthentication(email, password)) {
				Employee emp = new Employee();
				emp = AdminDao.getEmployeeByEmail(email);
				HttpSession session = request.getSession(true);	    
		        session.setAttribute("currentEmployee", emp);
				response.sendRedirect("employee.jsp");
			}
			else
				response.sendRedirect("login.jsp");
		}
	}

}
