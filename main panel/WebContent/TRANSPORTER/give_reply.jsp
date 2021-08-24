
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="COM.TRANSPORTER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_QUOTE_FILE" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_LOG_FILE" %>
	
<!doctype html>
<html lang="en" class="no-js">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/sweetalert.min.js"></script>
<script type="text/javascript">
$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
   
    $('#txtDate').attr('min', maxDate);
})


$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
   
    $('#txtDate1').attr('min', maxDate);
})
</script>
<jsp:include page="head.jsp"></jsp:include>
<title>GET QUOTE</title>
<body>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER").forward(request, response);
}
%>
<%
	BEAN_QUOTE_FILE one = (BEAN_QUOTE_FILE)request.getAttribute("quote");
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
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_TRANSPORTER?page=Send_Quote">Send Quote</a></li>
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
										<h2>Send Quote</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Send Quote</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->


<section class="contact-section">

					<div class="container">
					<div class="row">
							<div class="col-sm-6">
								<div class="quote-box">
					<form action="QUOTE_TWO" method="post" id="contact-form" id="contact-form"  name="myform">
					<label class="form-control">QUOTE_ID</label>
					<input class="form-control" name="quote_id" id="quote_id" type="text" value=<%=one.GET_QUOTE_ID()%> readonly>
					<label class="form-control">CUST_EMAIL</label>
					<input class="form-control" name="cust_mail" id="cust_mail" type="text" value=<%=one.GET_USER_NAME()%> readonly>
					<label class="form-control">CATEGORY_NAME</label>
					<input class="form-control" name="category_name" id="category_name" type="text" value=<%=one.GET_CATEGORY_NAME()%> readonly>
					<label class="form-control">SUB_CATEGORY_NAME</label>
					<input class="form-control" name="sub_category_name" id="sub_category_name" type="text" value=<%=one.GET_SUB_CATEGORY_NAME()%> readonly>
					<label class="form-control">SOURCE_NAME</label>
					<input class="form-control" name="source_name" id="source_name" type="text" value=<%=one.GET_SOURCE_NAME()%> readonly>
					<label class="form-control">DESTINATION_NAME</label>
					<input class="form-control" name="destination_name" id="destination_name" type="text" value=<%=one.GET_DESTINATION_NAME()%> readonly>
					<label class="form-control">ADDRESS</label>
					<input class="form-control" name="address" id="address" type="text" value=<%=one.GET_ADDRESS()%> readonly>
					<label class="form-control">FROM_DATE</label>
					<input class="form-control" name="from_date" id="from_date" type="text" value=<%=one.GET_FROM_DATE()%> readonly>
					<label class="form-control">TO_DATE</label>
					<input class="form-control" name="to_Date" id="to_Date" type="text" value=<%=one.GET_TO_DATE()%> readonly>
					<label class="form-control">MESSGAE</label>
					<textarea class="form-control" name="message" id="message" placeholder="Message" rows="4" cols="50" readonly><%=one.GET_MESSAGE()%></textarea>
					<label class="form-control">REPLY</label>
					<input class="form-control" name="reply" id="reply" type="text"  value="" placeholder="reply">
					<input type="hidden" name="id" value="<%=one.GET_QUOTE_ID()%>"> 
					<input type="submit" name="action" value="send">
					
					</form>
					</div>
					</div>
					</div>
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
