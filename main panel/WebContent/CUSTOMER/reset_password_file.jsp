<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
<%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<%-- <%
HttpSession ses = request.getSession();
Cookie cookie = new Cookie("JSESSIONID", session.getId());
cookie.setMaxAge(Integer.MAX_VALUE);
response.addCookie(cookie);
%> --%>
<script>

function validateform()
{   
	var x=document.myform.cust_email.value;  
	var atposition=x.indexOf("@");  
	var dotposition=x.lastIndexOf("."); 
	
	var firstpassword=document.myform.password.value;  
	var secondpassword=document.myform.confirm_password.value; 
	
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length)
	{  
	  alert("Please enter a valid e-mail address.");  
	  return false;  
	}  
	else if(firstpassword!=secondpassword)
	{  
		Swal.fire({
			  icon: 'error',
			  title: 'Oops...',
			  text: 'password must be same!'
			})
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
	min-height:390px;
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
<body onload="document.registration.cust_email.focus();">

	<!-- Container -->
	<div id="container">
		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content1">
					
						<jsp:include page="right_header.jsp"></jsp:include>

				
				
				
				<section class="contact-section">
						<%
							int id=(Integer) session.getAttribute("id");

							BEAN_LOG_FILE one = DAO_LOG_FILE.getUserById(id);
						%>
							<%-- <form id="contact-form" id="contact-form"  name="myform" method="post" action="CHANGE_PASSWORD_SERVLET" onsubmit="return validateform()">
								<h2>Forgot Password</h2>
								<input type="hidden" name="email" value=<%=one.GET_USER_NAME()%>><br>
								<label for="password">PASSWORD</label>
								<input type="text" name="password" required><br>
								<label for="confirm_password">CONFIRM_PASSWORD</label>
								<input type="text" name="confirm_password" required><br>
								
								
								<input type="submit" name="action" value="submit" />
							</form> --%>
					<div class="container">
							<div class="row" >
								<div class="col-md-4 col-md-offset-4" >
								<div class="login-wrap">
								<div class="login-html">
						                <div class="text-center" >
						                  <h3><i style="color:white" class="fa fa-lock fa-4x"></i></h3>
						                  <h2 class="text-center" style="color:white">Reset Password</h2>
						                  <p style="color:white">You can reset your password here.</p>
						    
						                    <form id="contact-form" id="contact-form"  name="myform" method="post" action="CHANGE_PASSWORD_SERVLET" onsubmit="return validateform()">
						    
						                     <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="password" name="password" placeholder="Password" class="form-control"  type="password" required>
						                          <input type="hidden" name="email" value=<%=one.GET_USER_NAME()%>><br>
						                      </div><br>
						                      <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="confirm_password" name="confirm_password" placeholder="Confirm Password" class="form-control"  type="password" required>
						                      </div><br>
						                      <div class="form-group">
						                        <input name="action" class="btn btn-lg btn-primary btn-block" value="submit" type="submit">
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