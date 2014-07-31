<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*, java.util.*, model.*, dbc.*, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Designate Associate</title>
</head>
<body>
	<%! Connection conn = DBconn.getConn(); %>
	Current designate:<br/>
	<% 
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select ename, dname from employee e, department d, empdpt ed where e.eid=ed.eid and d.did=ed.did");
			while(rs.next()) {
				out.print(rs.getString("ename") + " : ");
				out.print(rs.getString("dname"));
	%>
	<br/>
	<%
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	%>
	Choose employees and relative departments: <br/>
	<form action="DesignateDept" method="post">
		<br/>Employees:<br/>
		<%  
			ArrayList<Employee> empList = new ArrayList<Employee>();
			empList = AdminDao.getAllEmployees();
			for(Employee emp : empList) {
				out.println(emp.geteName());
		%>
		<input type="checkbox" name="emplist" value="<%= emp.getEid() %>">
		<br/>
		<%
			}
		%>
		<br/>Departments:<br/>
		<%  
			ArrayList<Department> dptList = new ArrayList<Department>();
			dptList = AdminDao.getAllDepartments();
			for(Department dpt : dptList) {
				out.println(dpt.getdName());
		%>
		<input type="checkbox" name="dptlist" value="<%= dpt.getDid() %>">
		<br/>
		<%
			}
		%>
		<input type="submit" name="confirm" value="Confirm"/>
	</form>
	<form action="admin.jsp" method="get">
		<input type="submit" name="back" value="Back"/>
	</form>
</body>
</html>