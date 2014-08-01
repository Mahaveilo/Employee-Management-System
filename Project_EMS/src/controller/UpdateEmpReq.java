package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import model.*;

/**
 * Servlet implementation class UpdateEmpReq
 */
@WebServlet("/UpdateEmpReq")
public class UpdateEmpReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpReq() {
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
		UpdateReq upr = new UpdateReq();
		HttpSession session = request.getSession();
		Employee emp = new Employee();
		emp = (Employee)session.getAttribute("currentEmployee");
		int eid = emp.getEid();
		upr.setEid(eid);
		upr.setAddress(request.getParameter("add"));
		upr.seteName(request.getParameter("ename"));
		upr.setImgPath(request.getParameter("imgp"));
		upr.setPassword(request.getParameter("pwd"));
		upr.setPhoneNum(request.getParameter("phon"));
		EmployeeDao.updateRequest(upr);
		response.sendRedirect("employee.jsp");
	}

}
