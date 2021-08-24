<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_PROFILE_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_PROFILE" %>
<!doctype html>
<html lang="en" class="no-js">
<script type="text/javascript">
</script>
<jsp:include page="head.jsp"></jsp:include>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER").forward(request, response);
}
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
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=About">About</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Send_Quote">Send Quote</a></li>
					<li style="border-bottom:3px solid black !important;" class="drop"><a class="active">My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					
						<li style="border-bottom:3px solid black !important;"><a class="active"  href="LOGIN_CONTROL_TRANSPORTER?page=View Profile">View Profile</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Change Password">Change Password</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Replied Quote">Replied Quote</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Orders">Orders</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Order History">Order History</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Order Receipt">Order Receipt</a></li>
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
					
						<jsp:include page="right_header.jsp"></jsp:include>
				<!-- contact section 
					================================================== -->
				<section class="contact-section">
					<div class="container">
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <!-- <thead>
                                        <tr>
                            				<th>CUST_ID</th>
                                            <th>EMIAL_ID</th>
                                            <th>FIRST_NAME</th>
                                            <th>LAST_NAME</th>
                                            <th>CONTACT</th>
                                            <th>EDIT</th>
                                        </tr>
                                    </thead> -->
                                    <tbody>
										 
										 <%
										 BEAN_PROFILE_FILE one = (BEAN_PROFILE_FILE)request.getAttribute("user_fun");
										%>
										<%-- <form action="PROFILE_ONE" method="post">
										
										 <td>
											<input type="text" name="id1" id="id1" value=<%=one.GET_USER_ID()%> readonly>
										</td> 
										 <td>
											<input type="text" name="usename1" id="username1" value=<%=one.GET_USER_NAME()%> readonly>
										</td> 
										
										<td>
											<input type="text" name="fname1" id="fname1" value=<%=one.GET_FIRST_NAME()%>>
										</td>
										
										<td>
											<input type="text" name="lname1" id="lname1" value=<%=one.GET_LAST_NAME()%>>
										</td>
										
										<td>
											<input type="text" name="contact1" id="contact1" value=<%=one.GET_CONTACT()%>>
										</td>
										
										<td>
											<input type="submit" name="action" value="save">
										</td>
										</form>
										</tr> --%>
										
										<form action="PROFILE_ONE" method="post">
										<tr>
										
										<th style="background-color: black;color: white;border-bottom-color: white;">EMIAL_ID</th>
                                            <td>
												<input type="text" name="usename1" id="username1" value=<%=one.GET_USER_NAME()%> readonly class="form-control">
											</td>
										</tr>
										
										<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">FIRST_NAME</th>
										<td>
											<input type="text" name="fname1" id="fname1" value="<%=one.GET_FIRST_NAME()%>" class="form-control">
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: black;color: white;border-bottom-color: white;">LAST_NAME</th>
										<td>
											<input type="text" name="lname1" id="lname1" value="<%=one.GET_LAST_NAME()%>" class="form-control">
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: black;color: white;border-bottom-color: white;">CONTACT</th>
										<td>
											<input type="text" name="contact1" id="contact1" value="<%=one.GET_CONTACT()%>" class="form-control">
										</td>
										</tr>
										
										<tr>
										   <th style="background-color: black;color: white;border-bottom-color: white;">SAVE</th>
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