<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       <%@page import="COM.CUSTOMER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_CATEGORY_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_CATEGORY_FILE" %>
     <%@page import="COM.CUSTOMER.DAO.DAO_AREA_FILE" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_AREA_FILE" %>
     <%@page import="COM.CUSTOMER.DAO.DAO_SUB_CATEGORY_FILE" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_SUB_CATEGORY_FILE" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>
    
    <%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
	<%@page import="COM.CUSTOMER.CONNECT.CONNECT_FILE" %>
	<%@page import="java.io.PrintWriter" %>
	
<!doctype html>
<html lang="en" class="no-js">
<script src="resources/sweetalert.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<jsp:include page="head.jsp"></jsp:include>
<title>GET QUOTE</title>
<style type="text/css">


div.stars {
    width: 290px;
    display: inline-block
}

.mt-200 {
    margin-top: 200px
}

input.star {
    display: none
}

label.star {
    float: right;
    padding: 10px;
    font-size: 36px;
    color: #4A148C;
    transition: all .2s
}

input.star:checked~label.star:before {
    content: '\f005';
    color: #FD4;
    transition: all .25s
}

input.star-5:checked~label.star:before {
    color: #FE7;
    text-shadow: 0 0 20px #952
}

input.star-1:checked~label.star:before {
    color: #F62
}

label.star:hover {
    transform: rotate(-15deg) scale(1.3)
}

label.star:before {
    content: '\f006';
    font-family: FontAwesome
}
</style>
<%
int one = Integer.parseInt(request.getParameter("trans_quote_id"));
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
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=Order History">Orders History</a></li>
					<li ><a href="LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders">Canceled Orders</a></li>
					</ul>
					<li style="border-bottom:3px solid black !important;"class="drop"><a>Packages</a>
					<ul class="dropdown" style="border:3px solid black !important;">
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=See Packages">See Packages</a></li>
						<li><a href="LOGIN_CONTROL_CUSTOMER?page=View Packages Orders">View Packages Orders</a></li>
						<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=Order History">Package Orders History</a></li>
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
										<h2>GIVE RATING TO TRANSPORTER</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>GIVE RATING TO TRANSPORTER</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->


				<section class="contact-section">
					<div class="container">
					<div class="container d-flex justify-content-center mt-200">
					    <div class="row">
					        <div class="col-md-12">
					            <div class="stars">
					                <form action="rate" method="post"  id="contact-form"> 
						                <input class="star star-5" id="star-5" type="radio" name="rate" value="5"/>
						                 <label class="star star-5" for="star-5"></label> <input class="star star-4" id="star-4" type="radio" name="rate" value="4"/> 
						                 <label class="star star-4" for="star-4"></label> <input class="star star-3" id="star-3" type="radio" name="rate" value="3"/> 
						                 <label class="star star-3" for="star-3"></label> <input class="star star-2" id="star-2" type="radio" name="rate" value="2"/>
						                  <label class="star star-2" for="star-2"></label> <input class="star star-1" id="star-1" type="radio" name="rate" value="1"/>
						                   <label class="star star-1" for="star-1"></label> 
					                   	<input type="hidden" name="trans_quote_id" value="<%=one%>" readonly>
										<input type="submit" name="action" value="submit">
									</form>
					            </div>
					        </div>
					    </div>
					</div>
					</div>


									

				</section>
				<!-- End quote section -->
				

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
<script type="text/javascript">
    $(document).ready(function () {
        $("#submit").on("click",function () {
           widow.location.href='rate';
        });
       
    });
</script>
</html>


