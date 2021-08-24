<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="COM.TRANSPORTER.DAO.DAO_LOG_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_LOG_FILE" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%
request.getRequestDispatcher("HOME_CONTROL_TRANSPORTER?page=Home").forward(request, response);
%>
</body>
</html>