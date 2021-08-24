<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>s
<body>
<%
request.getRequestDispatcher("HOME_CONTROL_CUSTOMER?page=Home").forward(request, response);
%>
</body>
</html>