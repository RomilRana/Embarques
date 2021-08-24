<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%
	String email = request.getParameter("email_id");
	String password = request.getParameter("password");
	
	if(email.equals("gsk@gmail.com") && password.equals("gaurav123"))
	{
		response.sendRedirect("index_1.jsp");
	}
	else
	{
		response.sendRedirect("error.jsp");
	}
%>
</body>
</html>