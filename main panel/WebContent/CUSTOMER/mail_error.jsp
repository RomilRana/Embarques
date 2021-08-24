<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="resources/sweetalert.min.js"></script>
<jsp:include page="head.jsp"></jsp:include>
<script>
function loa() 
{
	swal("Netwrok Error!", "Please Check Your Network Connection!", "error")
	.then((value) => {
		window.location.href = "LOGIN_CONTROL_CUSTOMER?page=Forget";
	});
}
</script>
<body  onload="loa()" style="background-color: #ccccff !important;">	 
</body>
</html>