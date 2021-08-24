<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_RATING_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE" %>
    <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<title>VIEW QUOTATION</title>

<body onload="loa();">
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER").forward(request, response);
}
%>
<%
BEAN_QUOTE_FILE one = (BEAN_QUOTE_FILE)request.getAttribute("quote3");

%>

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
					<div class="container" >
							<table class="table" style="border-radius: 1em !important;overflow: hidden;">
                                    <thead style="background-color:  #2874a6  !important;color:white;">
                                    
                                        <tr>
                                        	<th scope="col">QUOTE_ID</th>
                                            <th scope="col">COMPANY_NAME</th>
                                            <th scope="col">CATEGORY_NAME</th>
                                            <th scope="col">SUB_CATEGORY_NAME</th>
                                            <th scope="col">SOURCE_NAME</th>
                                            <th scope="col">DESTINATION_NAME</th>
                                            <th scope="col">ADDRESS</th>
                                            <th scope="col">FROM_DATE</th>
                                            <th scope="col">TO_DATE</th>
                                            <th scope="col">MESSAGE</th>
                                            <th scope="col">Reply</th>                       
                                            <th scope="col">Rating</th>
                                          
                                            <th scope="col">Select</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        HttpSession ses = request.getSession();
                            			int u_id = (Integer) ses.getAttribute("id");
                            			
                            			int q_id= one.GET_QUOTE_ID();
                            			
										DAO_QUOTE_FILE ed = new DAO_QUOTE_FILE();
										List<BEAN_QUOTE_FILE> list =ed.getAllInfo(u_id,q_id);
										for(BEAN_QUOTE_FILE info: list)
										{
											int trans_id=info.GET_TRANS_ID();
											DAO_RATING_FILE d1 = new DAO_RATING_FILE();
											int five = d1.getFiveCount(trans_id);

											DAO_RATING_FILE d3 = new DAO_RATING_FILE();
											int four = d3.getFourCount(trans_id);

											DAO_RATING_FILE d4 = new DAO_RATING_FILE();
											int three = d4.getThreeCount(trans_id);

											DAO_RATING_FILE d5 = new DAO_RATING_FILE();
											int two = d5.getTwoCount(trans_id);

											DAO_RATING_FILE d6 = new DAO_RATING_FILE();
											int onee = d6.getOneCount(trans_id);


											DAO_RATING_FILE d7 = new DAO_RATING_FILE();
											int zero = d7.getZeroCount(trans_id);



											DAO_RATING_FILE d8 = new DAO_RATING_FILE();
											int count = d8.getCount(trans_id);
											int average=0;
											if(onee==0 && two==0 && three==0 && four==0 && five==0 && count==0)
											{
												average=0;
											}
											else
											{
											try
											{
												average = average + (5*five + 4*four + 3*three + 2*two + 1*onee) / (five+four+three+two+onee);
											}
											catch(Exception e)
											{
												e.printStackTrace();
											}
											}
									%> 
	 
									<tr style="background-color:  #e8e8e8 ;border-top: 2px solid black !important;font-weight: bolder !important;">
										<td>
											<% out.println(info.GET_QUOTE_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_COMPANY_NAME()); %>
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
						            
						           
										<td>
											
												<form action="CONTROLLER_QUOTE_FILE" method="post">
												<input type="hidden" name="id11" value="<%=info.GET_QUOTE_ID()%>" readonly> 
												 <input type="submit" name="action" value="Select" style="background-color: #2ada5f;font-size: 14px;font-weight: bolder;">
												 </form> 
										</td>
										 
									</tr>
									<%
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