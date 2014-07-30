<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*, java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delEmp</title>
</head>
<body>
	<form action="DelEmployee" method="post">
		<%  
			AdminDao aDao = new AdminDao();
			ArrayList<Employee> list = new ArrayList<Employee>();
			list = aDao.getAllEmployees();
			for(Employee emp : list) {
				out.println(emp.geteName());
		%>
		<input type="checkbox" name="emplist" value="<%= emp.getEid() %>">
		<br/>
		<%
			}
		%>
		<input type="submit" name="delete" value="Delete"/>
	</form>
	<form action="admin.jsp" method="get">
		<input type="submit" name="back" value="Back"/>
	</form>
</body>
</html>