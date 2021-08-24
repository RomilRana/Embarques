<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="COM.TRANSPORTER.BEAN.BEAN_LOG_FILE" %>
     <%@page import="COM.CUSTOMER.BEAN.BEAN_AREA_FILE" %>
     <%@page import="COM.CUSTOMER.DAO.DAO_AREA_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_LOG_FILE" %>
    <%@page import="java.io.PrintWriter" %>
     <%@page import="COM.TRANSPORTER.CONNECT.CONNECT_FILE" %>
      <%@page import="java.sql.PreparedStatement" %>
       <%@page import="java.sql.ResultSet" %>
        <%@page import="java.sql.Connection" %>
        <%@page import="java.util.*" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

<body>
<%
if(null == session.getAttribute("id"))
{
	response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=Add Package\"; \r\n" + 
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
					
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_TRANSPORTER?page=Add Package">Add Package</a></li>
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
										<h2>Add Package</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
											<li>Add Package</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->
				
				<section class="contact-section">
					<div class="container">
							<form id="contact-form" id="contact-form"  name="myform" method="post" action="PACKAGE" enctype="multipart/form-data">
								
										<input class="form-control" name="trans_mail" id="trans_mail" type="hidden" value=<%=one.GET_TRANSPORTER_NAME()%> readonly>
										
										<label class="form-control">PACKAGE TITLE:</label>
										<input class="form-control" name="package_name" id="package_name" type="text" value="">
										
										<label class="form-control">DESCRIPTION:</label>
										<textarea class="form-control" name="package_description" id="package_description" placeholder="description" rows="4" cols="50"></textarea>
										
										<label class="form-control">UPLOAD VEHICAL IMAGE:</label>
										<input type="file" id="one" name="one"><br> 
									
										
										<label class="form-control">FROM::</label>
										<select name="from_name" id="from_name" class="form-control">
			                                <%
													DAO_AREA_FILE ed1 = new DAO_AREA_FILE();
													List<BEAN_AREA_FILE> list1 =ed1.getAllInfo();
			
													for(BEAN_AREA_FILE info: list1)
													{
											%>
					                        <option class="form-control" value="<%=info.GET_AREA_ID() %>" required> <%= info.GET_AREA_NAME() %>
					                        </option>
					                        <%
													}
					                   		 %>
					                        
					                        </select>
					                        <label class="form-control" >TO:</label>
										<select name="to_name" id="to_name" class="form-control">
			                                <%
													DAO_AREA_FILE ed2 = new DAO_AREA_FILE();
													List<BEAN_AREA_FILE> list2 =ed2.getAllInfo();
			
													for(BEAN_AREA_FILE info: list2)
													{
											%>
					                        <option class="form-control" value="<%=info.GET_AREA_ID() %>" required> <%= info.GET_AREA_NAME() %>
					                        </option>
					                        <%
															}
					                   		 %>
					                        
					                        </select><br>	
										
										<label class="form-control">PACKAGE PRICE:</label>
										<input class="form-control" name="package_price" id="package_price" type="text" value="">
										
										
								<input type="submit" name="action" value="submit" />
							</form>
					</div>
				</section>
				

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