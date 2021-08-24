<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="COM.DAO.DAO_USER_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_USER_FILE" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
alert("ENTER VALID DETAILS");
</script>
<body>
<%
	String email = request.getParameter("email_id");

 	DAO_USER_FILE ed = new DAO_USER_FILE();
	List<BEAN_USER_FILE> list =ed.getAllInfo();

	for(BEAN_USER_FILE info: list)
	{
	
	/* 	out.println(info.GET_USER_NAME());  */
		if(email.equals(info.GET_USER_NAME()))
		{
			response.sendRedirect("ERROR.jsp");
			break;
		}
	
	}
%>                
</body>
</html>