<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginAsAdmin</title>
</head>
<body>
	<form action="AdminPortal" method="post" accept-charset="utf-8">
        Password: <input type="password" name="password" placeholder="Your password" required/><br/><br/>
        <input type="submit" value="Login">
	</form>  
	<form action="login.jsp" method="get">
		<input type="submit" name="cancel" value="Cancel"/>
	</form>
</body>
</html>