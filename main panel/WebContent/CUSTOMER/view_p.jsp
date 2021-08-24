<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<script>
function myFunction() 
{
	var name="page=View Profile"; 
	window.location.replace("login.jsp?name="+name); 
}
</script> 
<body onload="myFunction()">

</body>
</html>