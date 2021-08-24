<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_PROFILE_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_PROFILE" %>
<!doctype html>
<html lang="en" class="no-js">
<script type="text/javascript">
</script>
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
					<li style="border-bottom:3px solid black !important;"class="drop"><a class="active">My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=View Profile">View Profile</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Change Password">Change Password</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Quote">View Quote</a></li>
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
										<h2>Edit Profile</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Edit Profile</li>
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
										 <%
										 BEAN_PROFILE_FILE one = (BEAN_PROFILE_FILE)request.getAttribute("user_fun");
										%>
										<form action="PROFILE_ONE" method="post">
										<tr>
										
										<th style="background-color: #2874a6;color: white;border-bottom-color: white;">EMIAL ID</th>
                                            <td>
												<input type="text" name="usename1" id="username1" value=<%=one.GET_USER_NAME()%> readonly class="form-control">
											</td>
										</tr>
										
										<tr> 
										<th style="background-color: #2874a6;color: white;border-bottom-color: white;">FIRST NAME</th>
										<td>
											<input type="text" name="fname1" id="fname1" value="<%=one.GET_FIRST_NAME()%>" class="form-control" >
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: #2874a6;color: white;border-bottom-color: white;">LAST NAME</th>
										<td>
											<input type="text" name="lname1" id="lname1" value="<%=one.GET_LAST_NAME()%>" class="form-control">
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: #2874a6;color: white;border-bottom-color: white;">CONTACT</th>
										<td>
											<input type="text" name="contact1" id="contact1" value="<%=one.GET_CONTACT()%>" class="form-control">
										</td>
										</tr>
										
										<tr>
										   <th style="background-color:#2874a6;color: white;border-bottom-color: white;">SAVE</th>
										  <td>
												<input type="hidden" name="id1" id="id1" value=<%=one.GET_USER_ID()%> readonly>
												<input type="submit" name="action" value="save" class="form-control">
											
										</td>
										</tr>
									</form>
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