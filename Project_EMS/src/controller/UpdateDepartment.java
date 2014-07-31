package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Department;
import dao.AdminDao;

/**
 * Servlet implementation class UpdateDepartment
 */
@WebServlet("/UpdateDepartment")
public class UpdateDepartment extends HttpServlet {
	// update department information
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDepartment() {
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
		Department dpt = new Department();
		dpt.setDid(Integer.parseInt(request.getParameter("did")));
		dpt.setdName(request.getParameter("dname"));
		AdminDao.updateDepartment(dpt);
		response.sendRedirect("admin.jsp");
	}

}
