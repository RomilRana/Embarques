<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>
    <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<script type="text/javascript">
</script>
<jsp:include page="head.jsp"></jsp:include>
<title>VIEW PROFILE</title>

<%
if(null == session.getAttribute("id"))
{
	response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=View Profile\"; \r\n" + 
		  		"		window.location.replace(\"LOGIN_CONTROL_CUSTOMER?name=\"+name); ");
	  pw.println("</script>");
}
%>
<body>

	<!-- Container -->
	<div id="container" class="scrollbar-ripe-malinka">

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
										<h2>Profile</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Profile</li>
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
										 <%
										 Cookie[] hi = request.getCookies();
											String uname="";
											
											if(hi!=null)
											{
												for(Cookie hello : hi)
												{
													if(hello.getName().equals("email"))
													{
														uname=hello.getValue();
													}
												}
											}
											int id;
											
											id=DAO_LOG_FILE.getIdByEmail(uname);
											
											BEAN_LOG_FILE one = DAO_LOG_FILE.getUserById(id);
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
											<input type="text" name="fname1" id="fname1" value="<%=one.GET_FIRST_NAME()%>" class="form-control" readonly>
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: #2874a6;color: white;border-bottom-color: white;">LAST NAME</th>
										<td>
											<input type="text" name="lname1" id="lname1" value="<%=one.GET_LAST_NAME()%>" class="form-control" readonly>
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: #2874a6;color: white;border-bottom-color: white;">CONTACT</th>
										<td>
											<input type="text" name="contact1" id="contact1" value="<%=one.GET_CONTACT()%>" class="form-control" readonly>
										</td>
										</tr>
										
										<tr>
										   <th style="background-color: #2874a6;color: white;border-bottom-color: white;">EDIT</th>
										  <td>
												<input type="hidden" name="id" id="id" value=<%=one.GET_USER_ID()%> readonly>
												<input type="submit" name="action" value="edit" class="form-control">
											
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