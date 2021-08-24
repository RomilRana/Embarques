<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_ORDER_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_ORDER_FILE" %>
        <%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>
      <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<title>VIEW PACKAGES</title>
<style>
/* THE END OF THE IMPORTANT STUFF */

</style>
<%
if(null == session.getAttribute("id"))
{
	 response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=View Packages Orders\"; \r\n" + 
		  		"		window.location.replace(\"LOGIN_CONTROL_CUSTOMER?name=\"+name); ");
	  pw.println("</script>");
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
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Quote">View Quote</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Orders">Orders</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Order History">Orders History</a></li>
					<li ><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders">Canceled Orders</a></li>
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
										<h2>View Canceled Orders</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>View Canceled Orders</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->  

				<section class="contact-section" style="overflow-x: auto;">
					<div class="container" >
							<table class="table" style="border-radius: 1em !important;overflow: hidden;">
							<%
										DAO_ORDER_FILE ed = new DAO_ORDER_FILE();
                                        HttpSession ses = request.getSession(false);
                                        
                            			int u_id = (Integer) ses.getAttribute("id");
										List<BEAN_ORDER_FILE> list =ed.getAllCancelInfo(u_id);
										
										if(!list.isEmpty())
										{
							%>									
							<thead style="background-color:  #2874a6   !important;color:white;">
										<tr>
                                        	<th>ORDER_ID</th>
                                            <th>CATEGORY_NAME</th>
                                            <th>SUB_CATEGORY_NAME</th>
                                            <th>SOURCE_NAME</th>
                                            <th>DESTINATION_NAME</th>
                                            <th>DESCRIPTION</th>
                                            <th>CANCEL_BY</th>
                                            <th>REASON</th>
                                            <th>DATE_OF_CANCEL</th>
                                            
                                        </tr>
                                     </thead>    
                                    <tbody>
                                    
										<% 
										for(BEAN_ORDER_FILE info: list)
										{
										%>
                                    
                                    
                                         
	 
										<tr style="background-color:  #e8e8e8 ;border-top: 2px solid black !important;font-weight: bolder !important;">
										<td data-th="ORDER_ID">
											<% out.println(info.GET_ORDER_ID()); %>
										</td>
										<td data-th="CATEGORY_NAME">
											<% out.println(info.GET_CATEGORY_NAME()); %>
										</td>
										<td data-th="SUB_CATEGORY_NAME">
											<% out.println(info.GET_SUB_CATEGORY_NAME()); %>
										</td>
										<td data-th="SOURCE_NAME">
											<% out.println(info.GET_SOURCE_NAME()); %>
										</td>
										<td data-th="DESTINATION_NAME">
											<% out.println(info.GET_DESTINATION_NAME()); %>
										</td>
										<td data-th="DESCRIPTION">
											<% out.println(info.GET_MESSAGE()); %>
										</td>
										<td data-th="CANCEL_BY">
											<% out.println(info.GET_CANCEL_BY()); %>
										</td>
										<td data-th="REASON">
											<% out.println(info.GET_REASON()); %>
										</td>
										<td data-th="CANCEL_DATE">
											<% out.println(info.GET_CANCEL_DATE()); %>
										</td>
									</tr> 
                                    </tbody>
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
				      		"	swal(\"Sorry!\", \"THERE IS NO CANCLED ORDERS\", \"info\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"LOGIN_CONTROL_CUSTOMER?page=Home\";\r\n" + 
				      		"	});\r\n" + 
				      		"}");
				      pw.println("</script>");
				      pw.println("<body  onload=\"loa()\"></body");
				      
										}
									%>
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