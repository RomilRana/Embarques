<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="resources/sweetalert.min.js"></script>
<jsp:include page="head.jsp"></jsp:include>
<script>  
function validateform()
{
	var firstpassword=document.myform.new_password.value;  
	var secondpassword=document.myform.confirm_password.value; 

	if(firstpassword!=secondpassword)
	{  
		swal("Oops!","new password and confirm password are not matched", "error")
		
		return false;   
	} 
}  

</script>
<style>
.login-wrap{
	width:100%;
	margin:auto;
	max-width:525px;
	min-height:400px;
	position:relative;
	background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
	box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}
.login-html{
	width:100%;
	height:100%;
	position:absolute;
	padding:0px 70px 0px 70px;
	background:rgba(40,57,101,.9);
}
</style>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<body>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Login").forward(request, response);
}
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
					<li style="border-bottom:3px solid black !important;"><a class="active" href="LOGIN_CONTROL_CUSTOMER?page=Change Password">Change Password</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="LOGIN_CONTROL_CUSTOMER?page=View Quote">View Quote</a></li>
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
										<h2>Change Password</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Change Password</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->
					
						<section class="contact-section">
					<div class="container">
							<div class="row" >
								<div class="col-md-4 col-md-offset-4" >
								<div class="login-wrap">
								<div class="login-html">
						                <div class="text-center" >
						                  <h3><i style="color:white" class="fa fa-lock fa-4x"></i></h3>
						              		<h2 class="text-center" style="color:white">Change Password</h2>
						                    <form id="register-form" role="form" autocomplete="off" class="form" name="myform" method="post" action="PROFILE_ONE" onsubmit="return validateform()">
						    
						                      <div class="form-group">
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="current_password" name="current_password" placeholder="current_password" class="form-control"  type="password"  required>
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                        <input id="new_password" name="new_password" placeholder="new_password" class="form-control"  type="password"  required>
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="confirm_password" name="confirm_password" placeholder="confirm_password" class="form-control"  type="password"  required>
						                        </div>
						                        
						                          
						                      </div>
						                      <div class="form-group">
						                        <input name="action" class="btn btn-lg btn-primary btn-block" value="Change" type="submit">
						                      </div>
						                      
						                      <input type="hidden" class="hide" name="token" id="token" value=""> 
						                    </form>
						    
						                  </div>
						                </div>
						              </div>
						            </div>
						          </div>
							</div>
				</section>
					
	

					
					<!-- End home section --> 
					
					<!-- footer 
					================================================== -->
					<jsp:include page="footer.jsp"></jsp:include>
				<!-- End footer -->
	
				</div>
			</div>
			<!-- End Content -->

</div>
<!-- Revolution slider -->
				<jsp:include page="script.jsp"></jsp:include>
<!-- End Container -->
</body>
</html>
