<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<script>
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
function validateform()
{  
	var fname=document.myform.first_name.value;
	var lname=document.myform.last_name.value;
	var password=document.myform.cust_password.value;  

	var x=document.myform.cust_email.value;  
	var atposition=x.indexOf("@");  
	var dotposition=x.lastIndexOf("."); 
	
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length)
	{  
	  alert("Please enter a valid e-mail address.");  
	  return false;  
	}  
	else if(password==null || password=="")
	{  
	  alert("Please enter Password.");  
	  return false;  
	}
	else if(password.length<6)
	{  
	  Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Password must be at least 6 characters long.'
		})
	  return false;  
	}  
	
}  
</script>
<%
	Cookie[] hi = request.getCookies();
	String uname="",password="";
	
	if(hi!=null)
	{
		for(Cookie hello : hi)
		{
			if(hello.getName().equals("cust_email"))
			{
				uname=hello.getValue();
			}
			if(hello.getName().equals("cust_password"))
			{
				password=hello.getValue();
			}
		}
	}
%>
<%
String name=request.getParameter("name");
if(name==null)
{
	name="page=Home";
}
	
%>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

<!------ Include the above in your HEAD tag ---------->

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style>
.login-wrap{
	width:100%;
	margin:auto;
	max-width:525px;
	min-height:450px;
	position:relative;
	background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
	box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}
.login-html{
	width:100%;
	height:100%;
	position:absolute;
	padding:0px 70px 50px 70px;
	background:rgba(40,57,101,.9);
}
</style>
<body onload="document.registration.cust_email.focus();">

	<!-- Container -->
	<div id="container">
		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content1">
					
						<jsp:include page="right_header.jsp"></jsp:include>

				
				<section class="contact-section">
							<div class="container">
							<div class="row" >
								<div class="col-md-4 col-md-offset-4" >
								<div class="login-wrap">
								<div class="login-html">
						                <div class="text-center" >
						                 <h3><i style="color:white" class="fa fa-user fa-4x"></i></h3>
						                  <h2 class="text-center" style="color:white">Sign In</h2>
						    
						                    <form id="contact-form" id="contact-form"  name="myform" method="post" action="LOG_ONE" onsubmit="return validateform()">
						    
						                      <div class="form-group">
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
						                          <input id="cust_email" name="cust_email" placeholder="email address" class="form-control"  type="email" value="<%=uname%>">
						                        </div><br>
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="cust_password" name="cust_password" placeholder="password" class="form-control"  type="password" value="<%=password %>">
						                          <input type="hidden"  name="name" value="<%=name%>"><br>
						                        </div><br>
						                        <div class="input-group">
						                          <input type="checkbox" name="remember" value="1"><span style="color:white">REMEMBER ME</span><br>
						                        </div><br>
						                       
						                      </div>
						                      <div class="form-group">
						                        <input name="action" class="btn btn-lg btn-primary btn-block" value="Sign In" type="submit">
						                      </div><br>
						                      <label class="pull-right">
                                					<a href="forgot_password.jsp" style="color:white">Forgotten Password?</a>
                            					</label>
						                    </form>
						    
						                  </div>
						                </div>
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
	