<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<script>
</script> 
<body>

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
					
					<!-- page-banner-section 
					================================================== -->
						<section class="page-banner-section">
							<div class="container">
								<div class="row">
									<div class="col-sm-6">
										<h2>About Us</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="HOME_CONTROL_TRANSPORTER?page=Home">HOME</a></li>
											<li>About us</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->  
					
					<!-- contact section 
					================================================== -->
				<section class="contact-section">
					<div class="container">
						
						<div class="row">

							<div class="col-sm-7">
								<div class="about-us-box">
									<h1>about us</h1>
									<p>National Courier Service in Sarangpur Ahmedabad is a well-known name.This Couiere service embarked on  its journey in 2002.</p>
									
								</div>
							</div>

							<div class="col-sm-5">
								
								<div class="about-box">
									<img src="resources/upload/others/iso1.jpg" alt=""><br>
									<h2>Who we are</h2>
									<p>We Provide our services in  Ahmedabad last 20 years. We give our best efforts to satisfy customer. </p>
								</div>

							</div>

						</div>
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
<!-- Revolution slider -->
				<jsp:include page="script.jsp"></jsp:include>
<!-- End Container -->
</body>
</html>