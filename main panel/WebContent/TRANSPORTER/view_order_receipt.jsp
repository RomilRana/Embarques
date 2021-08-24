<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.TRANSPORTER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_ORDER_FILE" %>
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
	BEAN_ORDER_FILE info = (BEAN_ORDER_FILE)request.getAttribute("order_recipt");
%>
<body>
<%
		if(null == session.getAttribute("id"))
		{
			 response.setContentType("text/html"); PrintWriter pw = response.getWriter();
			  pw.println("<script>");
			  pw.println("var name=\"page=Order Receipt\"; \r\n" + 
				  		"		window.location.replace(\"LOGIN_CONTROL_TRANSPORTER?name=\"+name); ");
			  pw.println("</script>");
		}
%>
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
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=About">About</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Send_Quote">Send Quote</a></li>
					<li style="border-bottom:3px solid black !important;" class="drop"><a class="active">My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Profile">View Profile</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Change Password">Change Password</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Replied Quote">Replied Quote</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Orders">Orders</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Order History">Order History</a></li>
						<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_TRANSPORTER?page=Order Receipt">Order Receipt</a></li>
						<li ><a href="LOGIN_CONTROL_TRANSPORTER?page=View Cancel Orders">Canceled Orders</a></li>
					</ul>
					</li>
					<li style="border-bottom:3px solid black !important;" class="drop"><a>Packages</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Add Package">Add Package</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package">View Package</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package Request">View Package Request</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package Order">View Package Order</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package Orders History">Package Orders History</a></li>
					<li ><a href="LOGIN_CONTROL_TRANSPORTER?page=View Cancel Package Orders">Canceled Package Orders</a></li>
					</ul>
					</li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Contact">Contact</a></li>
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
										<h2>Orders-Receipt</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
											<li>Orders-Receipt</li>
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
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
                                  
                                    <tbody>
									<tr>
										<th style="background-color: black;color: white;border-bottom-color: white;">QUOTE_ID</th>
										 <td>
											<input type="text" name="id1" id="id1" value="<%=info.GET_QUOTE_ID()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">CUSTOMER_NAME</th>
										<td>
											<input type="text" name="id2" id="id2" value="<%=info.GET_USER_NAME()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">CATEGORY_NAME</th>
										<td>
											<input type="text" name="id3" id="id3" value="<%=info.GET_CATEGORY_NAME()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">SUB_CATEGORY_NAME</th>
										<td>
											<input type="text" name="id4" id="id4" value="<%=info.GET_SUB_CATEGORY_NAME()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">COLLECTION_LOCATION</th>
										<td>
											<input type="text" name="id5" id="id5" value="<%=info.GET_SOURCE_NAME()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">DELIVERY_LOCATION</th>
										<td>
											<input type="text" name="id6" id="id6" value="<%=info.GET_DESTINATION_NAME()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">COLLECTION_DATE</th>
										<td>
											<input type="text" name="id6" id="id6" value="<%=info.GET_FROM_DATE()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">DELIVERY_DATE</th>
										<td>
											<input type="text" name="id6" id="id6" value="<%=info.GET_TO_DATE()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">MESSAGE</th>
										<td>
											<input type="text" name="id6" id="id6" value="<%=info.GET_MESSAGE()%>" readonly>
										</td>
									</tr>
									<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">Total Amount</th>
										<td>
											<input type="text" name="id6" id="id6" value="<%=info.GET_REPLY()%>" readonly>
										</td>
									</tr>
										
									
                                    </tbody>
                                </table>
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
