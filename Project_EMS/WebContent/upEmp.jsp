<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*, java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upEmp</title>
</head>
<body>
	<form action="UpdateEmpConfirm" method="post">
		<%  
			ArrayList<UpdateReq> list = new ArrayList<UpdateReq>();
			list = AdminDao.getUpdateReqs();
			for(UpdateReq upr : list) {
				out.println(upr.geteName());
		%>
		<input type="checkbox" name="uplist" value="<%= upr.getUpid() %>">
		<br/>
		<%
			}
		%>
		<input type="submit" name="update" value="Update"/>
	</form>
	<form action="admin.jsp" method="get">
		<input type="submit" name="back" value="Back"/>
	</form>
</body>
</html>