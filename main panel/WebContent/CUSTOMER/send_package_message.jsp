<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_PACKAGE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_PACKAGE_FILE" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>
    <%@page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="head.jsp"></jsp:include>
<title>SEND PACKAGE</title>
<%
	BEAN_PACKAGE_FILE info = (BEAN_PACKAGE_FILE)request.getAttribute("pack");
%>
<body>
<%
		if(null == session.getAttribute("id"))
		{
			 response.setContentType("text/html"); PrintWriter pw = response.getWriter();
			  pw.println("<script>");
			  pw.println("var name=\"page=Send Package Message\"; \r\n" + 
				  		"		window.location.replace(\"LOGIN_CONTROL_CUSTOMER?name=\"+name); ");
			  pw.println("</script>");
		}
%>
	<!-- Container -->
	<div id="container">

			<!-- Header
		    ================================================== -->
			<header class="clearfix" style="background-color: #183650 !important;">
			<div class="logo">
				<a href="index_1.jsp"><img src="resources1/images/login.png" alt="" height="100" width="300" style="border-radius: 0%;"></a>
			</div>

			<a class="elemadded responsive-link" href="#">Menu</a>

			<nav class="nav-menu">
				<ul class="menu-list" style="border:3px solid black !important;">
					<li style="border-bottom:3px solid black !important;" ><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=About">About</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Get Quote">Get Quote</a></li>
					<li style="border-bottom:3px solid black !important;"class="drop"><a >My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=View Profile">View Profile</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Change Password">Change Password</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Quote">View Quote</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Orders">Orders</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Order History">Orders History</a></li>
					<li ><a href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders">Canceled Orders</a></li>
					</ul>
					<li style="border-bottom:3px solid black !important;"class="drop"><a class="active" >Packages</a>
					<ul class="dropdown" style="border:3px solid black !important;">
						<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=See Packages">See Packages</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Packages Orders">View Packages Orders</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Package Order History">Package Orders History</a></li>
						<li ><a href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Package Orders">Canceled Package Orders</a></li>
					</ul>
					</li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Search">Search</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Contact">Contact</a></li>
					<li><a href="LOGIN_CONTROL_CUSTOMER?page=Sign Out">Sign Out</a></li>
				</ul>
			</nav>
		</header>
		<!-- End Header -->
		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content">
					
						<jsp:include page="login_right_header.jsp"></jsp:include>
						
						<section class="quote-section">
				
				<div class="container">
						<div class="row">
							<div class="col-sm-6">
								<div class="quote-box">
							<form id="contact-form" id="contact-form"  name="myform" method="post">
								
										
										<label class="form-control">PACKAGE TITLE:</label>
										<input class="form-control" name="package_name" id="package_name" type="text" value="<%=info.GET_PACKAGE_NAME()%>" readonly>
										
										<label class="form-control">COMPANY NAME:</label>
										<input class="form-control" name="company_name" id="package_name" type="text" value="<%=info.GET_COMPANY_NAME()%>" readonly>

										<label class="form-control">PACKAGE DESCRIPTION:</label>
										<textarea class="form-control" name="package_description" id="package_description" placeholder="description" rows="4" cols="50" readonly><%=info.GET_PACKAGE_DESCRIPTION()%></textarea>
										
										<label class="form-control">VEHICAL IMAGE:</label>
										<img alt="" src="../IMAGES/QUOTE/<%=info.GET_IMAGE_NAME()%>" height="100" width="100">	
										
										<label class="form-control">FROM:</label>
										<input class="form-control" name="from_name" id="from_name" type="text" value="<%=info.GET_FROM_NAME()%>" readonly>
										
										<label class="form-control">TO:</label>
										<input class="form-control" name="to_name" id="to_name" type="text" value="<%=info.GET_TO_NAME()%>" readonly>
										
										<label class="form-control">PACKAGE PRICE:</label>
										<input class="form-control" name="package_price" id="package_price" type="text" value="<%=info.GET_PACKAGE_PRICE()%>" readonly>
										
										<label class="form-control">DESCRIPTION:</label>
										<textarea class="form-control" name="description" id="description" placeholder="description" rows="4" cols="50" readonly><%=info.GET_PACKAGE_DESCRIPTION()%></textarea>
										
										
							</form>
							</div>

							</div>
							<div class="col-sm-6">
								<div class="quote-box">
									<h1>Billing Details</h1>
									
									<form action="PACKAGE_ORDER_GSK" method="post" id="contact-form" id="contact-form">
								
										<label class="form-control">First Name*</label>
										<input type="text" placeholder="First Name" class="form-control" name="first_name" required>
									
										<label class="form-control">Last Name*</label>
										<input type="text" placeholder="Last Name" class="form-control"  name="last_name" required>
									
										<label class="form-control">Phone no*</label>
										<input type="text" placeholder="Phone number" class="form-control" name="contact" required maxlength="10" minlength="10">
										
										<label class="form-control">Address*</label>
										<input type="text" placeholder="Address line 1" class="form-control"  name="add_1"  required>
										<input type="text" placeholder="Address line 2" class="form-control" name="add_2" required>
										

										<input type="hidden" name="id11" value="<%=info.GET_PACKAGE_ID()%>"> 
										<input type="submit" name="action" value="Send" />
                               		
									</form>
								</div>
							</div>
						</div>
					</div>

				</section>
				<!-- End quote section -->
				

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
