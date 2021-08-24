<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.TRANSPORTER.DAO.DAO_PACKAGE_ORDER_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_PACKAGE_ORDER_FILE" %>
        <%@page import="COM.TRANSPORTER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_LOG_FILE" %>
     
     <%@page import="java.io.PrintWriter" %>
     <%@page import="COM.TRANSPORTER.CONNECT.CONNECT_FILE" %>
      <%@page import="java.sql.PreparedStatement" %>
       <%@page import="java.sql.ResultSet" %>
        <%@page import="java.sql.Connection" %>
        <%
	
%>
<%
if(null == session.getAttribute("id"))
{
	 response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=View Package Order\"; \r\n" + 
		  		"		window.location.replace(\"LOGIN_CONTROL_TRANSPORTER?name=\"+name); ");
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
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<%
	if(session.isNew())
	{
		request.getRequestDispatcher("login.jsp").forward(request, response);
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
					<li style="border-bottom:3px solid black !important;" class="drop"><a>My Account</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Profile">View Profile</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Change Password">Change Password</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Replied Quote">Replied Quote</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Orders">Orders</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Order History">Order History</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Order Receipt">Order Receipt</a></li>
						<li ><a href="LOGIN_CONTROL_TRANSPORTER?page=View Cancel Orders">Canceled Orders</a></li>
					</ul>
					</li>
					<li style="border-bottom:3px solid black !important;" class="drop"><a class="active" >Packages</a>
					<ul class="dropdown" style="border:3px solid black !important;">
					
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=Add Package">Add Package</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package">View Package</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_TRANSPORTER?page=View Package Request">View Package Request</a></li>
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_TRANSPORTER?page=View Package Order">View Package Order</a></li>
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
										<h2>View Package Orders</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
											<li>View Package Orders</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->  

				<section class="contact-section" style="overflow-x: auto;">
					<div class="container" >
							<table class="table"  style="border-radius: 1em !important;overflow: hidden;">
							<%
							DAO_PACKAGE_ORDER_FILE ed = new DAO_PACKAGE_ORDER_FILE();
                            HttpSession ses = request.getSession(false);
                			int u_id = (Integer) ses.getAttribute("id");
							List<BEAN_PACKAGE_ORDER_FILE> list =ed.getAllInfo(u_id);
							if(!list.isEmpty())
							{

							%>
                                    <thead style="background-color:  #2874a6  !important;color:white;">
                                        <tr>
                                        	<th>USER_NAME</th>
                                            <th>PACKAGE_NAME</th>
                                            <th>PACKAGE_DESCRIPTION</th>
                                            <th>VEHICAL_IMAGE</th>
                                            <th>PACKAGE_PRICE</th>
                                            <th>FROM_AREA</th>
                                            <th>TO_AREA</th>
                                            <th>DELIVERED</th>
                                            <th>DISPATCH</th>
                                            <th>CANCEL</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                               			<%
										
										for(BEAN_PACKAGE_ORDER_FILE info: list)
										{
										%>	 
										<tr style="background-color:  #e8e8e8 ;border-top: 2px solid black !important;font-weight: bolder !important;">
										<td>
											<% out.println(info.GET_USER_NAME()); %>
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
										<form action="QUOTE_TWO" method="post">
											<input type="hidden" name="id" value="<%=info.GET_PACKAGE_BOOKING_ID()%>" readonly>
											<input type="hidden" name="id1" value="<%=info.GET_TRANSPORTER_ID()%>" readonly>
											<%
											Connection cn = CONNECT_FILE.sqlConnection();
											String query = "select * from package_order where package_booking_id=? and delivered=0";
											
											
											PreparedStatement ps = cn.prepareStatement(query);
											ps.setInt(1,info.GET_PACKAGE_BOOKING_ID());
											ResultSet rs = ps.executeQuery();
											if(rs.next())
											{ 
											%>
										 	<input type="submit" name="action" value="Delivered" style="background-color: #2ada5f;font-size: 14px;font-weight: bolder;">
										 	<%
											}
											else
											{
											%>
											<input type="submit" name="action" value="Success" disabled style="background-color: #e84038;font-size: 14px;font-weight: bolder;color: white;">
											<%
											}
											%>
										 </form>
										</td>
										<td>
										<form action="QUOTE_TWO" method="post">
											<input type="hidden" name="id" value="<%=info.GET_PACKAGE_BOOKING_ID()%>" readonly>
											<input type="hidden" name="id1" value="<%=info.GET_TRANSPORTER_ID()%>" readonly>
											<%
											Connection cn1 = CONNECT_FILE.sqlConnection();
											String query1 = "select * from package_order where package_booking_id=? and dispatch=0";
											
											
											PreparedStatement ps1 = cn1.prepareStatement(query1);
											ps1.setInt(1,info.GET_PACKAGE_BOOKING_ID());
											ResultSet rs1 = ps1.executeQuery();
											if(rs1.next())
											{ 
											%>
										 	<input type="submit" name="action" value="Dispatch" style="background-color: #2ada5f;font-size: 14px;font-weight: bolder;">
										 	<%
											}
											else
											{
											%>
											<input type="submit" name="action" value="Dispatched" disabled style="background-color: #e84038;font-size: 14px;font-weight: bolder;color: white;">
											<%
											}
											%>
										 </form>
										</td>
										<td>
										<form action="cancel_package.jsp" method="post">
											<input type="hidden" name="id" value="<%=info.GET_PACKAGE_BOOKING_ID()%>" readonly>
											<input type="hidden" name="id1" value="<%=info.GET_TRANSPORTER_ID()%>" readonly>
											<%
											Connection cn2 = CONNECT_FILE.sqlConnection();
											String query2 = "select * from package_order where package_booking_id=? and dispatch=0";
											
											
											PreparedStatement ps2 = cn2.prepareStatement(query2);
											ps2.setInt(1,info.GET_PACKAGE_BOOKING_ID());
											ResultSet rs2 = ps2.executeQuery();
											if(rs2.next())
											{ 
											%>
										 	<input type="submit" name="action" value="Cancel" style="background-color: #2ada5f;font-size: 14px;font-weight: bolder;">
										 	<%
											}
											else
											{
											%>
											<input type="submit" name="action" value="Cancel" disabled style="background-color: #e84038;font-size: 14px;font-weight: bolder;color: white;">
											<%
											}
											%>
										 </form>
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
				      		"	swal(\"Sorry!\", \"THERE IS NO Package Orders\", \"info\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Home\";\r\n" + 
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