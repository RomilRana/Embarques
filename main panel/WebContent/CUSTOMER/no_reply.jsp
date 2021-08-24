<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE" %>
    <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>

<script src="resources/sweetalert.min.js"></script>
<jsp:include page="head.jsp"></jsp:include>
<script>
function loa() 
{
	swal("Soory!","No reply from Transporter", "info")
	.then((value) => {
		window.location.href = "LOGIN_CONTROL_CUSTOMER?page=View Quote";
	});
}
</script>
<body onload="loa()">


</body>
</html>