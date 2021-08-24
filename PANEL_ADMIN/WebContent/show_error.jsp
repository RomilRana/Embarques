<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="RESOURCES/sweetalert.min.js"></script>
<script>
function loa() 
{
	swal("Error!", "You Can not Delete This Category Because SubCategory Exist For This Category", "error")
	.then((value) => {
		window.location.href = "HOME_CONTROL?page=View Category";
	});
}
</script>
<body  onload="loa()">	 
</body>
</html>