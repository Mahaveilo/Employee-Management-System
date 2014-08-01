<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
	Your are: <br/>
	<%! Employee emp = new Employee(); %>
	<% 
		emp = (Employee)session.getAttribute("currentEmployee");
		out.print(emp.geteName());
	%>
	<br/><br/>Update Request: <br/>
	<form action="UpdateEmpReq" method="post" accept-charset="utf-8">
		name: <input type="text" name="ename" required><br/>
		password: <input type="text" name="pwd" required><br/>
		address: <input type="text" name="add" required><br/>
		phone number: <input type="text" name="phon" required><br/>
		img path: <input type="text" name="imgp" required><br/>
		<input type="submit" name="update" value="Update">
	</form>
	<form action="login.jsp" method="get">
		<input type="submit" name="logout" value="Logout"/>
	</form>
</body>
</html>