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
	swal("Soory!","There is no Quote", "info")
	.then((value) => {
		window.location.href = "LOGIN_CONTROL_CUSTOMER?page=Home";
	});
}
</script>
<body onload="loa()">


	<!-- Container -->
	<div id="container">

		<!-- Header
		    ================================================== -->
			<jsp:include page="header.jsp"></jsp:include>
		<!-- End Header -->

		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content">
					
						<jsp:include page="right_header.jsp"></jsp:include>

				<!-- home-section 
					================================================== -->
					
						<jsp:include page="slider.jsp"></jsp:include>
				
				<!-- End home section -->
				
				
				<!-- contact section 
					================================================== -->
				<section class="contact-section" style="overflow-x: auto;">
					<div class="container">
							
					</div>
				</section>
				<!-- End contact section -->
				<!-- footer 
					================================================== -->
					<jsp:include page="footer.jsp"></jsp:include>
				<!-- End footer -->
			</div>
		</div>
		<!-- End Content -->

	</div>
	<!-- End Container -->
	
	<!-- Revolution slider -->
		<jsp:include page="script.jsp"></jsp:include>
</body>
</html>