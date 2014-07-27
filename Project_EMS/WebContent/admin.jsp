<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
	<form action="addEmp.jsp" method="get">
		Add employee: 
		<input type="submit" name="addE" value="submit"/>
	</form>
	<form action="delEmp.jsp" method="get">
		Delete employee: 
		<input type="submit" name="delE" value="submit"/>
	</form>
	<form action="upEmp.jsp" method="get">
		Update Employee: 
		<input type="submit" name="upE" value="submit"/>
	</form>
	<form action="addDpt.jsp" method="get">
		Add department: 
		<input type="submit" name="addD" value="submit"/>
	</form>
	<form action="delDpt.jsp" method="get">
		Delete department: 
		<input type="submit" name="delD" value="submit"/>
	</form>
	<form action="upDpt.jsp" method="get">
		Update Department:
		<input type="submit" name="upD" value="submit"/>
	</form>
	<form action="" method="get">
		<input type="submit" name="logout" value="Logout"/>
	</form>
	<ol>
		<li><><>
	<ol>
</body>
</html>