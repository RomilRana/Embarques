<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="COM.TRANSPORTER.BEAN.BEAN_USER_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_LOG_FILE" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<%-- <%
HttpSession ses = request.getSession();
Cookie cookie = new Cookie("JSESSIONID", session.getId());
cookie.setMaxAge(Integer.MAX_VALUE);
response.addCookie(cookie);
%> --%>
<style>
.login-wrap{
	width:100%;
	margin:auto;
	max-width:525px;
	min-height:440px;
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
<body onload="document.registration.cust_email.focus();">
<%

BEAN_USER_FILE second = (BEAN_USER_FILE)request.getAttribute("user_register");
%>
	<!-- Container -->
	<div id="container">
		<!-- content 
			================================================== -->
		<div id="content">
				<div class="inner-content1">
					
						<jsp:include page="right_header.jsp"></jsp:include>

				
				
				
				<section class="contact-section">
					<%-- <div class="container">
					
							<form id="contact-form" id="contact-form"  name="myform" method="post" action="VERIFY_OTP">
								<h2>Verify OTP</h2>
										<input type="hidden" name="first_name" id="first_name" value="<%=second.GET_FIRST_NAME() %>">
										<input type="hidden" name="last_name" id="last_name" value="<%=second.GET_LAST_NAME() %>">
										<input type="hidden" name="contact" id="contact" value="<%=second.GET_CONTACT() %>">
										<input type="hidden" name="cust_email" id="cust_email" value="<%=second.GET_USER_NAME() %>">
										<input type="hidden" class="form-control" name="cust_password" id="cust_password" value="<%=second.GET_USER_PASSWORD() %>"><br>
								<label for="otp">OTP</label>
								<input type="text" name="otp" required><br>
								
								<input type="submit" name="action" value="submit" />
							</form>
					</div> --%>
					<div class="container">
							<div class="row" >
								<div class="col-md-4 col-md-offset-4" >
								<div class="login-wrap">
								<div class="login-html">
						                <div class="text-center" >
						                  <h3><i style="color:white" class="fa fa-lock fa-4x"></i></h3>
						              		<h2 class="text-center" style="color:white">OTP Verification</h2>
						                  <p style="color:white">Please enter the 4-digit verification code we sent via Mail:.</p>
						                    <form id="register-form" role="form" autocomplete="off" class="form" method="post" action="VERIFY_OTP">
						    
						                      <div class="form-group">
						                        <div class="input-group">
						                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
						                          <input id="otp" name="otp" placeholder="OTP" class="form-control"  type="text" maxlength="4" minlength="4" required>
						                          <input type="hidden" name="first_name" id="first_name" value="<%=second.GET_FIRST_NAME() %>">
													<input type="hidden" name="last_name" id="last_name" value="<%=second.GET_LAST_NAME() %>">
													<input type="hidden" name="contact" id="contact" value="<%=second.GET_CONTACT() %>">
													<input type="hidden" name="trans_email" id="trans_email" value="<%=second.GET_USER_NAME() %>">
													<input type="hidden" name="company_name" id="company_name" value="<%=second.GET_COMPANY_NAME() %>">
													<input type="hidden" class="form-control" name="trans_password" id="trans_password" value="<%=second.GET_USER_PASSWORD() %>"><br>
						                        </div>
						                      </div>
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