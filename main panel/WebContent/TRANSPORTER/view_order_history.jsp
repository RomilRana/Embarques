<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_ORDER_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_ORDER_FILE" %>
      <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<title>ORDERS</title>
<%
if(null == session.getAttribute("id"))
{
	response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=Order History\"; \r\n" + 
		  		"		window.location.replace(\"LOGIN_CONTROL_TRANSPORTER?name=\"+name); ");
	  pw.println("</script>");
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
					
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Profile">View Profile</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Change Password">Change Password</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Replied Quote">Replied Quote</a></li>
						<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_TRANSPORTER?page=Orders">Orders</a></li>
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
					
						<jsp:include page="login_right_header.jsp"></jsp:include>

					<!-- page-banner-section 
					================================================== -->
						<section class="page-banner-section">
							<div class="container">
								<div class="row">
									<div class="col-sm-6">
										<h2>Order History</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
											<li>Order History</li>
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
						<div class="table-responsive">
							<table class="table" style="border-radius: 1em !important;overflow: hidden;">
							<%
							int id=(Integer) session.getAttribute("id");
							DAO_ORDER_FILE ed = new DAO_ORDER_FILE();
							List<BEAN_ORDER_FILE> list =ed.getAllInfo2(id);
							if(!list.isEmpty())
							{
							%>
							<thead style="background-color:  #2874a6  !important;color:white;">
                                        <tr>
                                            <th>QUOTE_ID</th>
                                            <th>CUSTOMER_MAIL</th>
                                            <th>CATEGORY_NAME</th>
                                            <th>SUB_CATEGORY_NAME</th>
                                            <th>SOURCE_NAME</th>
                                            <th>DESTINATION_NAME</th>
                                            <th>DELIVERY_DATE</th>
                                            <th>MESSAGE</th>
                                            <th>Reply</th>
                                            <th>Receipt</th>
                                        </tr>
                                    </thead>
							<%
										
										for(BEAN_ORDER_FILE info: list)
										{
												int c_id=info.GET_TRANS_ID();
												int o_id=info.GET_ORDER_ID();
									%> 
                                    
                                    <tbody>
                                        
	 
									<tr style="background-color:  #e8e8e8 ;border-top: 2px solid black !important;font-weight: bolder !important;">
										<td>
											<% out.println(info.GET_QUOTE_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_USER_NAME()); %>
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
											<% out.println(info.GET_TO_DATE()); %>
										</td>
										<td>
											<% out.println(info.GET_MESSAGE()); %>
										</td>
										<td>
											<% out.println(info.GET_REPLY()); %>
										</td>
										<td>
										<form action="QUOTE_TWO" method="post">
										
										<input type="hidden" name="id11" value="<%=info.GET_TRANS_QUOTE_ID()%>" readonly>
							 
										<input type="submit" name="action" value="View" class="form_control">
										</form>
										</td>
										
										
									</tr>
									
                                    </tbody>
                                            <%
											}
										}
										else
										{
									%>
								<% 
                                	response.setContentType("text/html");
				      PrintWriter pw = response.getWriter();
				      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
				      pw.println("<script>");
				      pw.println("function loa() \r\n" + 
				      		"{\r\n" + 
				      		"	swal(\"Sorry!\", \"THERE IS NO PREVIVIOUS ORDERS\", \"info\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Home\";\r\n" + 
				      		"	});\r\n" + 
				      		"}");
				      pw.println("</script>");
				      pw.println("<body  onload=\"loa()\"></body");
				      %>
									<%
										}
									%>
                                </table>
                        
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