<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Login").forward(request, response);
}
%>

<body style="background-color: #ccccff !important;">
	<!-- Container -->
	<div id="container" style="background-color: #ccccff !important;">

		<!-- Header
		    ================================================== -->
			<jsp:include page="login_head.jsp"></jsp:include>
		<!-- End Header -->

		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content">
					
						<jsp:include page="login_right_header.jsp"></jsp:include>

				<!-- home-section 
					================================================== -->
					
						<jsp:include page="slider.jsp"></jsp:include>
				
				<!-- End home section -->
				
				<!-- banner-section 
					================================================== -->
				<section class="banner-section">
					<div class="container">
						<h2>For Free Quote<a href="LOGIN_CONTROL_CUSTOMER?page=Get Quote" class="button-one">click here</a></h2>
					</div>
				</section>
				<!-- End banner section -->
				
				<!-- testimonial-section 
					================================================== -->
				<section class="testimonial-section">
					<div class="container">

						<div class="title-section">
							<h1>Clients Testimonials</h1>
						</div>

						<div class="testimonial-box">
							<ul class="bxslider">
								<li>
									<h2>Sunny Rana</h2>
									<span>EMBARQUES Chief</span>
									<p>We Provide our services in  Ahmedabad last 20 years.<br>  We give our best efforts to satisfy customer.</p>
								</li>
							</ul>
						</div>

					</div>
				</section>
				<!-- End testimonial section -->
				

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