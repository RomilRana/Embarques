<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_PACKAGE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_PACKAGE_FILE" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	BEAN_PACKAGE_FILE info = (BEAN_PACKAGE_FILE)request.getAttribute("pack");
%>
<jsp:include page="head.jsp"></jsp:include>

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
					<li style="border-bottom:3px solid black !important;"class="drop"><a>My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Profile">View Profile</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Change Password">Change Password</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Quote">View Quote</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Orders">Orders</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Order History">Orders History</a></li>
					<li ><a href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders">Canceled Orders</a></li>
					</ul>
					<li style="border-bottom:3px solid black !important;"class="drop"><a class="active">Packages</a>
					<ul class="dropdown" style="border:3px solid black !important;">
						<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=See Packages">See Packages</a></li>
						<li><a href="LOGIN_CONTROL_CUSTOMER?page=View Packages Orders">View Packages Orders</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Order History">Package Orders History</a></li>
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
										<h2>Confirm Package Order</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Confirm Package Order</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->

				<!-- page-banner-section 
					================================================== -->
						<section class="page-banner-section">
							<div class="container">
								<div class="row">
									<div class="col-sm-6">
										<h2>View Quote</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>View Quote</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->
				
				
				<!-- contact section 
					================================================== -->
				<section class="contact-section" style="overflow-x: auto;">
					<div class="container">
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                        	<th>TRANSPORTER_EMAIL</th>
                                            <th>PACKAGE_NAME</th>
                                            <th>PACAGE_DESCRIPTION</th>
                                            <th>VEHICAL_IMAGE</th>
                                            <th>PACKAGE_PRICE</th>
                                            <th>FROM_AREA</th>
                                            <th>TO_AREA</th>
                                             <th>SELECT</th>
                                        </tr>
                                    </thead>
                                    <tbody>
									<tr>
										<td>
											<% out.println(info.GET_TRANSPORTER_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_PACKAGE_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_PACKAGE_DESCRIPTION()); %>
										</td>
										<td>
											<img alt="" src="../IMAGES/QUOTE/<%=info.GET_IMAGE_NAME()%>" height="100" width="100">	
										</td>
										<td>
											<% out.println(info.GET_PACKAGE_PRICE()); %>
										</td>
										<td>
											<% out.println(info.GET_FROM_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_TO_NAME()); %>
										</td>
										<td>
									</tr>
									
                                    </tbody>
                                </table><br>
                               		<form action="ORDER_ONE" method="post">
												<input type="hidden" name="id11" value="<%=info.GET_PACKAGE_ID()%>" readonly> 
												 <input type="submit" name="action" value="confirm" class="form_control">
									</form> 
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