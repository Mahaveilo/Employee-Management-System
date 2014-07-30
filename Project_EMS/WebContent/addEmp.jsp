<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addEmp</title>
</head>
<body>
	<form action="AddEmployee" method="post" accept-charset="utf-8">
		Name: <input type="text" name="ename" required/><br/>
		Password: <input type="text" name="pwd" required/><br/>
		Address: <input type="text" name="add"/><br/>
		Phone: <input type="text" name="phone"/><br/>
		Email: <input type="email" name="email" required/><br/>
		Salary: <input type="text" name="salary"/><br/>
		Is Manager: <input type="radio" name="ismanager" value="1">Yes 
		<input type="radio" name="ismanager" value="0">No<br/>
		Manager: <input type="text" name="manager" /><br/>
		<input type="submit" name="back" value="Add"/>
	</form>
	<form action="admin.jsp" method="get">
		<input type="submit" name="back" value="Back"/>
	</form>
</body>
</html>