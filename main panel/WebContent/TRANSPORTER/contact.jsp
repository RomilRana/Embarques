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
										<h2>Contact Us</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="HOME_CONTROL_TRANSPORTER?page=Home">HOME</a></li>
											<li>Contact us</li>
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
						<div class="col-sm-12">
							<div class="contact-info">
								<h2>Contact Info</h2>
								<p>You can contact or visit us in our office from Monday to Saturday from 10am-6pm</p>
								<ul class="information-list">
									<li><i class="fa fa-map-marker"></i><span>207, New Cloth Market, 1st Floor, Sarangpur, Ahmedabad - 380002</span></li>
									<li><i class="fa fa-phone"></i><span>079-22166048</span><span></span></li>
									<li><i class="fa fa-envelope-o"></i><a href="#">EMBARQUES@gmail.com</a></li>
								</ul>						
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