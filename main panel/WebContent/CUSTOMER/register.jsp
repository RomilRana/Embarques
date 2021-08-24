<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" class="no-js">
<script src="resources/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<jsp:include page="head.jsp"></jsp:include>
<title>REGISTER</title>
<script>  
function validateform()
{  
	var fname=document.myform.first_name.value;
	var lname=document.myform.last_name.value; 
	var password=document.myform.cust_password.value;  

	var x=document.myform.cust_email.value;  
	var atposition=x.indexOf("@");  
	var dotposition=x.lastIndexOf(".");
	
	var num=document.myform.contact.value;
	
	var firstpassword=document.myform.cust_password.value;  
	var secondpassword=document.myform.confirm_password.value; 
	
	if (fname==null || fname=="")
	{
		swal("Oops!","First Name can not be blank", "error")
	  return false;  
	}
	else if (lname==null || lname=="")
	{  
		swal("Oops!","Last Name can not be blank", "error")
	  return false;  
	}
	else if(password.length<6)
	{  
		swal("Oops!","Password must be at least 6 characters long", "error")
	  return false;  
	}  
	else if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length)
	{  
	  alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
	  return false;  
	}  
	else if (isNaN(num))
	{  
		swal("Oops!","In Contact Enter Numeric value only", "error")
	  	return false;  
	}
	else if(firstpassword!=secondpassword)
	{  
		swal("Oops!","password must be same!", "error")
		return false;   
	} 
}  

</script>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<style>
.login-wrap{
	width:100%;
	margin:auto;
	max-width:525px;
	min-height:580px;
	position:relative;
	background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
	box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}
.login-html{
	width:100%;
	height:100%;
	position:absolute;
	padding:0px 70px 20px 70px;
	background:rgba(40,57,101,.9);
}
</style>
<body onload="document.registration.first_name.focus();">

	<!-- Container -->
	<div id="container">

		<!-- Header
		    ================================================== -->
			<%-- <jsp:include page="header.jsp"></jsp:include> --%>
		<!-- End Header -->

		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content1">
					
						<jsp:include page="right_header.jsp"></jsp:include>

				<!-- home-section 
					================================================== -->
					
						<%-- <jsp:include page="slider.jsp"></jsp:include> --%>
				
				<!-- End home section -->
				
				
				<!-- contact section 
					================================================== -->
				<section class="contact-section" id="us">
				
							<%-- <form id="contact-form" id="contact-form"  name="myform" method="post" action="LOG_ONE" onsubmit="return validateform()">
								<h2>LOGIN CUSTOMER</h2>
								<label for="email_id">EMAIL_ID</label>
								<input type="text" name="cust_email" value="<%=uname%>" required><br>
								<label for="password">Password</label>
								<input type="password" class="form-control" name="cust_password" value="<%=password %>"  required><br>
								
								<input type="hidden"  name="name" value="<%=name%>"><br>
								
								<input type="checkbox" name="remember" value="1">REMEMBER ME<br>
								
								 <label class="pull-right">
                                	<a href="forgot_password.jsp">Forgotten Password?</a>
                            	</label>
								<input type="submit" name="action" value="submit" />
							</form>  --%>
							<div class="container">
							<div class="row" >
								<div class="col-md-4 col-md-offset-4" >
								<div class="login-wrap">
								<div class="login-html">
						                <div class="text-center" >
						                  <h3><i style="color:white" class="fa fa-user fa-4x"></i></h3>
						                  <h2 class="text-center" style="color:white">Register</h2>
						    
						                    <form id="register-form" role="form" autocomplete="off" class="form" method="post" action="USER_ONE" onsubmit="return validateform()">
						    
						                      <div class="form-group">
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-pencil color-blue"></i></span>
						                          <input id="first_name" name="first_name" placeholder="First Name" class="form-control"  type="text">
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-pencil color-blue"></i></span>
						                          <input id="last_name" name="last_name" placeholder="Last Name" class="form-control"  type="text">
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
						                          <input id="cust_email" name="cust_email" placeholder="Email Address" class="form-control"  type="email">
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-pencil color-blue"></i></span>
						                          <input id="contact" name="contact" placeholder="Contact" class="form-control"  type="text" maxlength="10"  minlength="10" required>
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="cust_password" name="cust_password" placeholder="Password" class="form-control"  type="password">
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="confirm_password" name="cust_password" placeholder="Confirm Password" class="form-control"  type="password">
						                        </div><br>
						                      </div>
						                      <div class="form-group">
						                        <input name="action" class="btn btn-lg btn-primary btn-block" value="Sign Up" type="submit">
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