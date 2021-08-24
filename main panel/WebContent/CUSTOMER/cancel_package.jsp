
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="COM.CUSTOMER.DAO.DAO_QUOTE_FILE"%>
<%@page import="java.util.List"%>
<%@page import="COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="COM.CUSTOMER.CONNECT.CONNECT_FILE"%>
<%@page import="java.io.PrintWriter"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<title>SELECT QUOTE</title>

<%
	if (null == session.getAttribute("id")) {
		request.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER").forward(request, response);
	}
	int id = Integer.parseInt(request.getParameter("id"));
%>
<%
	Connection cn = CONNECT_FILE.sqlConnection();
	String query = "select * from package_order where package_booking_id=? and dispatch=1";

	PreparedStatement ps = cn.prepareStatement(query);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
		pw.println("<script>");
		pw.println("function loa() \r\n" + "{\r\n"
				+ "	swal(\"Sorry!\", \"You can't cancel the order because it is dispatched!\", \"error\")\r\n"
				+ "	.then((value) => {\r\n"
				+ "		window.location.href = \"LOGIN_CONTROL_CUSTOMER?page=Home\";\r\n" + "	});\r\n" + "}");
		pw.println("</script>");
		pw.println("<body  onload=\"loa()\"></body");
	} else {
%>
<body>

	<!-- Container -->
	<div id="container">

		<!-- Header
		    ================================================== -->
		<header class="clearfix" style="background-color: #183650 !important;">
		<div class="logo">
			<a href="index_1.jsp"><img src="resources1/images/login.png"
				alt="" height="100" width="300" style="border-radius: 0%;"></a>
		</div>

		<a class="elemadded responsive-link" href="#">Menu</a> <nav
			class="nav-menu">
		<ul class="menu-list" style="border: 3px solid black !important;">
			<li style="border-bottom: 3px solid black !important;"><a
				href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
			<li style="border-bottom: 3px solid black !important;"><a
				href="LOGIN_CONTROL_CUSTOMER?page=About">About</a></li>
			<li style="border-bottom: 3px solid black !important;"><a
				href="LOGIN_CONTROL_CUSTOMER?page=Get Quote">Get Quote</a></li>
			<li style="border-bottom: 3px solid black !important;" class="drop"><a>My
					Account</a>
				<ul class="dropdown" style="border: 3px solid black !important;">
					<li style="border-bottom: 3px solid black !important;"><a
						href="LOGIN_CONTROL_CUSTOMER?page=View Profile">View Profile</a></li>
					<li style="border-bottom: 3px solid black !important;"><a
						href="LOGIN_CONTROL_CUSTOMER?page=Change Password">Change
							Password</a></li>
					<li style="border-bottom: 3px solid black !important;"><a
						href="LOGIN_CONTROL_CUSTOMER?page=View Quote">View Quote</a></li>
					<li style="border-bottom: 3px solid black !important;"><a
						href="LOGIN_CONTROL_CUSTOMER?page=Orders">Orders</a></li>
					<li style="border-bottom: 3px solid black !important;"><a
						href="LOGIN_CONTROL_CUSTOMER?page=Order History">Orders
							History</a></li>
					<li><a href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders">Canceled
							Orders</a></li>
				</ul>
			<li style="border-bottom: 3px solid black !important;" class="drop"><a
				class="active">Packages</a>
				<ul class="dropdown" style="border: 3px solid black !important;">
					<li style="border-bottom: 3px solid black !important;"><a
						href="LOGIN_CONTROL_CUSTOMER?page=See Packages">See Packages</a></li>
					<li style="border-bottom: 3px solid black !important;"><a
						class="active"
						href="LOGIN_CONTROL_CUSTOMER?page=View Packages Orders">View
							Packages Orders</a></li>
					<li style="border-bottom: 3px solid black !important;"><a
						href="LOGIN_CONTROL_CUSTOMER?page=Order History">Package
							Orders History</a></li>
					<li><a
						href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Package Orders">Canceled
							Package Orders</a></li>
				</ul></li>
			<li style="border-bottom: 3px solid black !important;"><a
				href="LOGIN_CONTROL_CUSTOMER?page=Search">Search</a></li>
			<li style="border-bottom: 3px solid black !important;"><a
				href="LOGIN_CONTROL_CUSTOMER?page=Contact">Contact</a></li>
			<li><a href="LOGIN_CONTROL_CUSTOMER?page=Sign Out">Sign Out</a></li>
		</ul>
		<!--  --> </nav> </header>

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
							<h2>Cancel Package Order</h2>
						</div>
						<div class="col-sm-6">
							<ul class="page-depth">
								<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
								<li>Cancel Package Order</li>
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
								<h1>Cancel Package Detail</h1>

								<form action="ORDER_ONE" method="post" id="contact-form"
									id="contact-form">
									<input type="hidden" name="id" value="<%=id%>" readonly>

									<label class="form-control">DESCRIBE_US_WHY</label> <input
										type="text" name="reason" value="" class="form-control">


									<input type="submit" name="action" value="cancel-package"
										class="form_control">
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
<% 
}
%>
</html>
