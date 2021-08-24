<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.TRANSPORTER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_QUOTE_FILE" %>
    <%@page import="java.sql.*"%>
    <%@page import="java.sql.Statement"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Connection"%>
	<%@page import="COM.TRANSPORTER.CONNECT.CONNECT_FILE" %>
	<%@page import="java.io.PrintWriter"%>
	

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<title>CANCEL ORDER</title>

<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER").forward(request, response);
}
int id = Integer.parseInt(request.getParameter("id"));
int id1 = Integer.parseInt(request.getParameter("id1"));
%>
<body>

	<!-- Container -->
	<div id="container">

				<!-- Header
		    ================================================== -->
		<header class="clearfix"  style="background-color: #183650 !important;">
			<div class="logo">
				<a href="LOGIN_CONTROL_TRANSPORTER"><img src="resources/images/login.png" alt="" height="150" width="300"></a>
			</div>

			<a class="elemadded responsive-link" href="#">Menu</a>

			<nav class="nav-menu">
				<ul class="menu-list" style="border:3px solid black !important;">
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=About">About</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Send_Quote">Send Quote</a></li>
					<li style="border-bottom:3px solid black !important;" class="drop"><a>My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Profile">View Profile</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Replied Quote">Replied Quote</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Orders">Orders</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package">View Package</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Cancel Orders">View Canceled Orders</a></li>
						<li><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package Order">View Package Order</a></li>
					</ul>
					</li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Contact">Contact</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Add Package">Add Package</a></li>
					<li><a href="LOGIN_CONTROL_TRANSPORTER?page=Sign Out">Sign Out</a></li>
				</ul>
			</nav>
		</header>
		<!-- End Header -->
		
		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content">
					
						<jsp:include page="login_right_header.jsp"></jsp:include>

				<!-- page-banner-section 
					================================================== -->
						<section class="page-banner-section">
							<div class="container">
								<div class="row">
									<div class="col-sm-6">
										<h2>Cancel Order</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
											<li>Cancel Order</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->
				
				
				<!-- contact section 
					================================================== -->
				<section class="quote-section">
					<div class="container">
						<div class="row">
							<div class="col-sm-6">
								<div class="quote-box">
									<h1>Order Cancel Detail</h1>
					
						<form action="PACKAGE" method="post" id="contact-form" id="contact-form">
							<input type="hidden" name="id" value="<%=id%>" readonly>
							<input type="hidden" name="id1" value="<%=id1%>" readonly>
						
							<label class="form-control">DESCRIBE_US_WHY</label> 
							<input type="text" name ="reason" value="" class="form-control">
							
							
							<input type="submit" name="action" value="cancel" class="form_control">
							</form> 
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
	<!-- End Container -->
	
	<!-- Revolution slider -->
		<jsp:include page="script.jsp"></jsp:include>
</body>

</html>