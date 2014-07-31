<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*, java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delDpt</title>
</head>
<body>
	<form action="DelDepartment" method="post">
		<%  
			ArrayList<Department> list = new ArrayList<Department>();
			list = AdminDao.getAllDepartments();
			for(Department dpt : list) {
				out.println(dpt.getdName());
		%>
		<input type="checkbox" name="dptlist" value="<%= dpt.getDid() %>">
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