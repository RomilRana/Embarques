<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>

<!-- Container -->
	<div id="container">
	
	<!-- Header
	================================================== -->
		    <jsp:include page="login_head.jsp"></jsp:include>
	<!-- End Header -->
		    
	<!-- content 
				================================================== -->
			<div id="content">
				<div class="inner-content">
					
					<jsp:include page="right_header.jsp"></jsp:include>
	
					<!-- home-section ================================================== -->
	
					<jsp:include page="slider.jsp"></jsp:include>
					
					<!-- End home section --> 
					
					<!-- footer 
					================================================== -->
					<jsp:include page="footer.jsp"></jsp:include>
				<!-- End footer -->
	
				</div>
			</div>
			<!-- End Content -->

</div>
<!-- Revolution slider -->
				<jsp:include page="script.jsp"></jsp:include>
<!-- End Container -->
</body>
</html>