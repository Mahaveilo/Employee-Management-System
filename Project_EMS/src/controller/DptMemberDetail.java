package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagerDao;
import model.Employee;

/**
 * Servlet implementation class DptMemberDetail
 */
@WebServlet("/DptMemberDetail")
public class DptMemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DptMemberDetail() {
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
		PrintWriter out = response.getWriter();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps = ManagerDao.dptMembers(Integer.parseInt(request.getParameter("dptlist")));
		out.println("<html><body>");
		out.println("<p>");
		for(Employee emp : emps) {
			out.println(emp.geteName());
			out.println("<br/>");
		}
		out.println("</p>");
		out.println("</html></body>");
		//response.sendRedirect("manager.jsp");
	}

}
