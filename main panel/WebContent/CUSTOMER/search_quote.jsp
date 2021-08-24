<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE" %>
    <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Login").forward(request, response);
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
										<h2>View Quote</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="index_1.jsp">Home</a></li>
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
							<table class="table" style="border-radius: 1em !important;overflow: hidden;">
							 <%
                                        HttpSession ses = request.getSession();
                            			int u_id = (Integer) ses.getAttribute("id");
                            			
										DAO_QUOTE_FILE ed = new DAO_QUOTE_FILE();
										List<BEAN_QUOTE_FILE> list =ed.getAllInfo1(u_id);
										if(!list.isEmpty())
										{
											%>
                                    <thead style="background-color:  #2874a6  !important;color:white;">
                                        <tr>
                                        	<th>QUOTE_ID</th>
                                            <th>CATEGORY_NAME</th>
                                            <th>SUB_CATEGORY_NAME</th>
                                            <th>SOURCE_NAME</th>
                                            <th>DESTINATION_NAME</th>
                                            <th>ADDRESS</th>
                                            <th>FROM_DATE</th>
                                            <th>TO_DATE</th>
                                            <th>MESSAGE</th>
                                            <th>VIEW</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <%

										for(BEAN_QUOTE_FILE info: list)
										{
									%> 
	 
									<tr style="background-color:  #e8e8e8 ;border-top: 2px solid black !important;font-weight: bolder !important;">
										<td>
											<% out.println(info.GET_QUOTE_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_CATEGORY_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_SUB_CATEGORY_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_SOURCE_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_DESTINATION_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_ADDRESS()); %>
										</td>
										<td>
											<% out.println(info.GET_FROM_DATE()); %>
										</td>
										<td>
											<% out.println(info.GET_TO_DATE()); %>
										</td>
										<td>
											<% out.println(info.GET_MESSAGE()); %>
										</td>
										<td>
											
												<form action="CONTROLLER_QUOTE_FILE" method="post">
												<input type="hidden" name="id11" value="<%=info.GET_QUOTE_ID()%>" readonly> 
												 <input type="submit" name="action" value="View" style="background-color: #2ada5f;font-size: 14px;font-weight: bolder;color: white;">
												 </form> 
										</td>
										
										
									</tr>
									                                <%
											}
										}
										else
										{
									
                                	response.setContentType("text/html");
				      PrintWriter pw = response.getWriter();
				      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
				      pw.println("<script>");
				      pw.println("function loa() \r\n" + 
				      		"{\r\n" + 
				      		"	swal(\"Sorry!\", \"THERE IS NO QUOTES\", \"info\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"LOGIN_CONTROL_CUSTOMER?page=Home\";\r\n" + 
				      		"	});\r\n" + 
				      		"}");
				      pw.println("</script>");
				      pw.println("<body  onload=\"loa()\"></body");
				      
										}
									%>
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