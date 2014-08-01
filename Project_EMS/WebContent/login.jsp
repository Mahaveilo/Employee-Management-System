<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="LoginPortal" method="post" accept-charset="utf-8">
		Email: <input type="email" name="email" placeholder="Valid email Address" required/><br/>
		Password: <input type="password" name="password" placeholder="Your password" required/><br/><br/>
		<input type="radio" name="managerLogin" value="maneger"/> Login as Manager <br/><br/>
		<input type="submit" name="login" value="Login"/>
	</form>

	<form action="adminLogin.jsp" method="get">
		Login as Admin: 
		<input type="submit" name="adminLogin" value="Confirm"/>
	</form>
</body>
</html>