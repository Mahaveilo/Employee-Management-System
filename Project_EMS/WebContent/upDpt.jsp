<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*, java.util.*, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upDpt</title>
<link rel="stylesheet" type="text/css" href="UpdDept.css" media="screen" />
<script type="text/javascript" src="UpdDept.js"></script>
</head>
<body>
  <section class="main"><!-- adding class -->
    <div class="displayDiv"><!-- adding class -->
	<form action="UpdateDepartment" method="post" class="form">
		<%  
			ArrayList<Department> list = new ArrayList<Department>();
			list = AdminDao.getAllDepartments();
			for(Department dpt : list) {
				out.println(dpt.getdName());
		%>
		<input type="radio" name="did" value="<%= dpt.getDid() %>">
		<br/>
		<%
			}
		%>
		<input class="inputField" type="text" name="dname" required/>
		<input class="executeBtn" type="submit" name="update" value="Update"/>
	</form>
    </div><!-- adding class -->
    <div class="inputDiv"><!-- adding class -->
	<form class="form" action="admin.jsp" method="get">
		<input type="image" class="backBtn" src="backBtn.png" width="25px" height="25px" />
	</form>
    </div><!-- adding class -->
  </section><!-- adding class -->
</body>
</html>
