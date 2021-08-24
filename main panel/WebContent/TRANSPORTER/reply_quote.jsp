<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.TRANSPORTER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_QUOTE_FILE" %>
      <%@page import="COM.TRANSPORTER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_LOG_FILE" %>
    
     <%@page import="java.io.PrintWriter" %>
     <%@page import="COM.TRANSPORTER.CONNECT.CONNECT_FILE" %>
      <%@page import="java.sql.PreparedStatement" %>
       <%@page import="java.sql.ResultSet" %>
        <%@page import="java.sql.Connection" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>

<%
if(null == session.getAttribute("id"))
{
	response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=Replied Quote\"; \r\n" + 
		  		"		window.location.replace(\"LOGIN_CONTROL_TRANSPORTER?page=Login?name=\"+name); ");
	  pw.println("</script>");
}
%>
<%
							int id=(Integer) session.getAttribute("id");

							BEAN_LOG_FILE one = DAO_LOG_FILE.getUserById(id);
							
							String uname=one.GET_TRANSPORTER_NAME();

							try
							{
								Connection cn = CONNECT_FILE.sqlConnection();
								String query = "select * from trans_table where trans_email=? and is_join=1";
								
								PreparedStatement ps = cn.prepareStatement(query);
								System.out.println(uname);
								ps.setString(1,uname);
								ResultSet rs = ps.executeQuery();
								if(!rs.next())
								{
									response.setContentType("text/html");
								      PrintWriter pw = response.getWriter();
								      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
								      pw.println("<script>");
								      pw.println("function loa() \r\n" + 
								      		"{\r\n" + 
								      		"	swal(\"Opps!\", \"Please Pay The Join Amount!\", \"error\")\r\n" + 
								      		"	.then((value) => {\r\n" + 
								      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Home\";\r\n" + 
								      		"	});\r\n" + 
								      		"}");
								      pw.println("</script>");
								      pw.println("<body  onload=\"loa()\"></body");
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
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
						<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_TRANSPORTER?page=Replied Quote">Replied Quote</a></li>
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
					
						<jsp:include page="login_right_header.jsp"></jsp:include>

			<!-- page-banner-section 
					================================================== -->
						<section class="page-banner-section">
							<div class="container">
								<div class="row">
									<div class="col-sm-6">
										<h2>Replied-Quote</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="index-1.jsp">Home</a></li>
											<li>Replied-Quote</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->  
				<section class="contact-section" style="overflow-x: auto;">
					<div class="container">
							<table class="table">
							<%
							DAO_QUOTE_FILE ed = new DAO_QUOTE_FILE();
							List<BEAN_QUOTE_FILE> list =ed.getAllInfo(id);
							if(!list.isEmpty())
							{
							%>
                                    <thead style="background-color:  #1931ff  !important;color:white;">
                                        <tr>
                                            <th>QUOTE_ID</th>
                                            <th>CUST_EMAIL</th>
                                            <th>CATEGORY_NAME</th>
                                            <th>SUB_CATEGORY_NAME</th>
                                            <th>SOURCE_NAME</th>
                                            <th>DESTINATION_NAME</th>
                                            <th>ADDRESS</th>
                                            <th>FROM_DATE</th>
                                            <th>TO_DATE</th>
                                            <th>MESSAGE</th>
                                            <th>Reply</th>
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
										<form action="QUOTE_TWO" method="post">
										<td>
											<% out.println(info.GET_USER_NAME()); %>
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
											<% out.println(info.GET_REPLY()); %>
										</td>
										
										</form>
										 
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
				      		"	swal(\"Sorry!\", \"THERE IS NO REPLIED QUOTES\", \"info\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Home\";\r\n" + 
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