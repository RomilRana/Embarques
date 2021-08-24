<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	BEAN_QUOTE_FILE one = (BEAN_QUOTE_FILE)request.getAttribute("quote");
%>
<jsp:include page="head.jsp"></jsp:include>
<title>SELECT QUOTE</title>

<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER").forward(request, response);
}
%>
<body>

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
					<li style="border-bottom:3px solid black !important;"class="drop"><a class="active">My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Profile">View Profile</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Change Password">Change Password</a></li>
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=View Quote">View Quote</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Orders">Orders</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Order History">Orders History</a></li>
					<li ><a href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders">Canceled Orders</a></li>
					</ul>
					<li style="border-bottom:3px solid black !important;"class="drop"><a>Packages</a>
					<ul class="dropdown" style="border:3px solid black !important;">
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=See Packages">See Packages</a></li>
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

				<!-- page-banner-section 
					================================================== -->
						<section class="page-banner-section">
							<div class="container">
								<div class="row">
									<div class="col-sm-6">
										<h2>Confirm Order</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Confirm Order</li>
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
									<h1>Order Details</h1>
					
						<form action="ORDER_ONE" method="post">
						
							<label class="form-control">QUOTE_ID:</label> 
							<input type="text" name ="quote_id" value="<%=one.GET_QUOTE_ID()%>" class="form-control" readonly>
							
							<label class="form-control">COMPANY NAME:</label>
							<input type="text" name ="company_name" value="<%=one.GET_COMPANY_NAME()%>" class="form-control" readonly>
							
							<label class="form-control">CATEGORY:</label>
							<input type="text" name ="category_name" value="<%=one.GET_CATEGORY_NAME()%>" class="form-control" readonly>
							
							<label class="form-control">SUB CATEGORY:</label>
							<input type="text" name ="sub_category_name" value="<%=one.GET_SUB_CATEGORY_NAME()%>" class="form-control" readonly>
							
							<label class="form-control">SOURCE:</label>
							<input type="text" name ="source_name" value="<%=one.GET_SOURCE_NAME()%>" class="form-control" readonly>
							
							<label class="form-control">DESTINATION:</label>
							<input type="text" name ="destination_name" value="<%=one.GET_DESTINATION_NAME()%>" class="form-control" readonly>
							
							<label class="form-control">ADDRESS:</label>
							<input type="text" name ="address" value="<%=one.GET_ADDRESS()%>" class="form-control" readonly>
							
							<label class="form-control">FROM DATE:</label>
							<input type="text" name ="from_date" value="<%=one.GET_FROM_DATE()%>" class="form-control" readonly>
							
							<label class="form-control">TO DATE:</label>
							<input type="text" name ="to_date" value="<%=one.GET_TO_DATE()%>" class="form-control" readonly>
							
							<label class="form-control">MESSAGE:</label>
							<textarea name ="message" rows="4" cols="50" class="form-control" readonly><%=one.GET_MESSAGE()%></textarea>
							
							<label class="form-control">REPLY:</label>
							<input type="text" name ="reply" value="<%=one.GET_REPLY()%>" class="form-control" readonly>
							
							</form> 
					
								</div>

							</div>
							
							<div class="col-sm-6">
								<div class="quote-box">
									<h1>Billing Details</h1>
									
									<form action="ORDER_ONE" method="post" id="contact-form" id="contact-form">
								
										<label class="form-control">First Name*</label>
										<input type="text" placeholder="First Name" class="form-control" name="first_name" required>
									
										<label class="form-control">Last Name*</label>
										<input type="text" placeholder="Last Name" class="form-control"  name="last_name" required>
									
										<label class="form-control">Phone no*</label>
										<input type="text" placeholder="Phone number" class="form-control" name="contact" required maxlength="10" minlength="10">

										<input type="hidden" name="id11" value="<%=one.GET_QUOTE_ID()%>" readonly>
							 
										<input type="submit" name="action" value="CONFIRM" class="form_control">
                               		
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