<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>

<body>

	<!-- Container -->
	<div id="container">
		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content1">
					
						<jsp:include page="right_header.jsp"></jsp:include>

				
				
				
				<section class="contact-section">
					<div class="container">
				
							<form id="contact-form" id="contact-form"  name="myform" method="post" action="GENERATE_NOTIFICATION" onsubmit="return validateform()">
								
								
								
								<input type="submit" name="action" value="submit" />
							</form>
					</div>
				</section>
				

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