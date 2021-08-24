<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="resources/sweetalert.min.js"></script>
<jsp:include page="head.jsp"></jsp:include>
<script>
function loa() 
{
	swal("Opps!", "You Entered Wrong Details!", "error")
	.then((value) => {
		window.location.href = "login.jsp";
	});
}
</script>
<body  onload="loa()">	 
</body>
</html>