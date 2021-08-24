<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_PROFILE_FILE" %>
      <%@page import="COM.TRANSPORTER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_PROFILE" %>
     <%@page import="COM.TRANSPORTER.DAO.DAO_LOG_FILE" %>
     <%@page import="COM.CUSTOMER.DAO.DAO_RATING_FILE" %>
     <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<script type="text/javascript">
</script>
<jsp:include page="head.jsp"></jsp:include>


<%
if(null == session.getAttribute("id"))
{
	response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=View Profile\"; \r\n" + 
		  		"		window.location.replace(\"LOGIN_CONTROL_TRANSPORTER?name=\"+name); ");
	  pw.println("</script>");
}
%>
<body >


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
											<li><a href="LOGIN_CONTROL_TRANSPORTER?page=Home">Home</a></li>
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
										 HttpSession ses = request.getSession(false);
										 int id=(Integer) ses.getAttribute("id");

										 BEAN_LOG_FILE two = DAO_LOG_FILE.getUserById(id);
										 
												
											DAO_PROFILE d1 = new DAO_PROFILE();
											BEAN_PROFILE_FILE one = d1.GET_BY_UID(two.GET_TRANSPORTER_ID());
											int trans_id=id;
											DAO_RATING_FILE d11 = new DAO_RATING_FILE();
											int five = d11.getFiveCount(trans_id);

											DAO_RATING_FILE d3 = new DAO_RATING_FILE();
											int four = d3.getFourCount(trans_id);

											DAO_RATING_FILE d4 = new DAO_RATING_FILE();
											int three = d4.getThreeCount(trans_id);

											DAO_RATING_FILE d5 = new DAO_RATING_FILE();
											int twoo = d5.getTwoCount(trans_id);

											DAO_RATING_FILE d6 = new DAO_RATING_FILE();
											int onee = d6.getOneCount(trans_id);


											DAO_RATING_FILE d7 = new DAO_RATING_FILE();
											int zero = d7.getZeroCount(trans_id);



											DAO_RATING_FILE d8 = new DAO_RATING_FILE();
											int count = d8.getCount(trans_id);
											int average=0;
											if(onee==0 && twoo==0 && three==0 && four==0 && five==0 && count==0)
											{
												average=0;
											}
											else
											{
											try
											{
												average = average + (5*five + 4*four + 3*three + 2*twoo + 1*onee) / (five+four+three+twoo+onee);
											}
											catch(Exception e)
											{
												e.printStackTrace();
											}
											}
									
										%>
										 <tr>
										<th style="background-color:  #1931ff;color: white;border-bottom-color: white;">EMIAL_ID</th>
                                            <td>
											<input type="text" name="id1" id="id1" value="<%=one.GET_USER_NAME()%>" readonly class="form-control">
											</td>
										</tr>
										
										<tr> 
										<th style="background-color:  #1931ff;color: white;border-bottom-color: white;">FIRST_NAME</th>
										<td>
											<input type="text" name="id2" id="id2" value="<%=one.GET_FIRST_NAME()%>" readonly class="form-control">
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color:  #1931ff;color: white;border-bottom-color: white;">LAST_NAME</th>
										<td>
											<input type="text" name="id3" id="id3" value="<%=one.GET_LAST_NAME()%>" readonly class="form-control">
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color:  #1931ff;color: white;border-bottom-color: white;">CONTACT</th>
										<td>
											<input type="text" name="id4" id="id4" value="<%=one.GET_CONTACT()%>" readonly class="form-control">
										</td>
										</tr>
										<tr>
										<th style="background-color:  #1931ff;color: white;border-bottom-color: white;">RATING</th>
										<td>
										
										<span class="product-rating"><%out.println(average); %></span><span>/5</span>
							<div style="width:125px;"> 
						            <%for(int i=0;i<average;i++)
						            	{%><i class="fa fa-star"></i>
						            	<%} %>
						            	<%for(int i=0;i<5-average;i++)
						            	{%><i class="fa fa-star-o"></i>
						            		<%} %>
						            		      	</div>
						            <div class="rating-text"> <% if(count>1){%><span><%out.println(count); %> Reviews</span><%}else{ %><span><%out.println(count); %> Review</span><%} %> </div>
										</td>
										</tr>
										<tr>
										   <th style="background-color:  #1931ff;color: white;border-bottom-color: white;">EDIT</th>
										  <td>
											<form action="PROFILE_ONE" method="post">
												<input type="hidden" name="id" value="<%=one.GET_USER_ID()%>" readonly>
												<input type="submit" name="action" value="edit" class="form-control" style="background-color: #2ada5f;font-size: 14px;font-weight: bolder;">
											</form>
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