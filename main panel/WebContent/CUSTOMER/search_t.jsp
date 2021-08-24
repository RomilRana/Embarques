<%@page import="COM.CUSTOMER.BEAN.TransporterModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search transpoter</title>
<jsp:include page="head.jsp"></jsp:include>
<title>SEARCH TRANSPORTER</title>
</head>
<%
	if (null == session.getAttribute("id")) {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<script>");
		pw.println("var name=\"page=Search\"; \r\n"
				+ "		window.location.replace(\"LOGIN_CONTROL_CUSTOMER?name=\"+name); ");
		pw.println("</script>");
	}
%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"href="path/to/font-awesome/css/font-awesome.min.css">
<style>
body .bbbootstrap {
		!important;
	background-size: cover;
	padding: 180px 0 30px 0
}

.bbbootstrap {
	padding: 40px;
	margin-bottom: 22px;
	color: #fff;
	text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
	background-color: #2e9df7;
	-webkit-box-shadow: 0 15px 15px -15px rgba(0, 0, 0, 0.25) inset, 0 -15px
		15px -15px rgba(0, 0, 0, 0.25) inset;
	box-shadow: 0 15px 15px -15px rgba(0, 0, 0, 0.25) inset, 0 -15px 15px
		-15px rgba(0, 0, 0, 0.25) inset
}

.bbbootstrap form {
	position: relative;
	width: 540px;
	margin: 22px auto 0
}

span {
	margin: 0;
	padding: 0;
	border: 0;
	outline: 0;
	font-weight: inherit;
	font-style: inherit;
	font-size: 100%;
	font-family: inherit;
	vertical-align: baseline
}

.bbbootstrap form input[type="text"] {
	padding: 15px 20px;
	padding-right: 100px;
	border-color: transparent;
	border-radius: 4px
}

input.InputBox {
	font-family: "lucida grande", "Lucida Sans Unicode", tahoma, sans-serif;
	color: #333;
	font-size: 15px;
	padding: 3px;
	margin: 0;
	width: 250px;
	background: #fff;
	border: 1px solid #999;
	border: 1px solid rgba(0, 0, 0, 0.4)
}

input[type=text] {
	box-sizing: border-box
}

.InputBox {
	display: block;
	width: 100% !important;
	padding: 6px 12px;
	font-size: 15px;
	line-height: 22px;
	border-radius: 4px
}

.bbbootstrap form input[type="submit"] {
	position: absolute;
	top: 5px;
	right: 5px;
	float: right;
	padding: 10px 25px
}

body .Button, body .button {
	background-color: #1268b3;
	background-image: none
}

input[type="submit"] {
	-webkit-appearance: button;
	cursor: pointer
}

.Button, .Button:hover, .Button:focus, .Button:active {
	text-shadow: none;
	border-color: transparent
}

.Button {
	display: inline-block;
	padding: 6px 12px;
	vertical-align: middle;
	font-size: 13px;
	font-weight: 700;
	line-height: 22px;
	text-transform: uppercase;
	border: transparent solid 1px;
	border-radius: 3px;
	-webkit-transition: -webkit-box-shadow 50ms;
	transition: -webkit-box-shadow 50ms;
	-o-transition: box-shadow 50ms;
	transition: box-shadow 50ms;
	transition: box-shadow 50ms, -webkit-box-shadow 50ms;
	-webkit-font-smoothing: inherit;
	color: #fff;
	background-color: #2e9df7;
	background-repeat: repeat-x;
	background-color: #38a2f7;
	background-image: -webkit-linear-gradient(#38a2f7, #2498f7);
	background-image: -webkit-gradient(linear, left top, left bottom, from(#38a2f7),
		to(#2498f7));
	background-image: -o-linear-gradient(#38a2f7, #2498f7);
	background-image: linear-gradient(#38a2f7, #2498f7)
}
</style>
<body>
	<div id="container">

		<jsp:include page="login_head.jsp"></jsp:include>

		<div id="content">
			<div class="inner-content">

				<jsp:include page="login_right_header.jsp"></jsp:include>

				<%
					ArrayList<TransporterModel> transporters = null;
					if (session.getAttribute("transporter") != null) {
						try {
							transporters = (ArrayList<TransporterModel>) session.getAttribute("transporter");
						} catch (Exception exception) {
							transporters = new ArrayList<TransporterModel>();
						}
					} else {
						transporters = new ArrayList<TransporterModel>();
					}
				%>
				<!-- page-banner-section 
					================================================== -->
				<section class="page-banner-section">
					<div class="container">
						<div class="row">
							<div class="col-sm-6">
								<h2>Search Transporter</h2>
							</div>
							<div class="col-sm-6">
								<ul class="page-depth">
									<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
									<li>Search Transporter</li>
								</ul>
							</div>
						</div>
					</div>
				</section>
				<!-- End page-banner section -->
				<section class="quote-section">
					<div class="container">
						<!-- <form action="TransporterSearchController1" method="post">
									<label class="form-control"> Enter pincode </label> 
									<input type="text" name="pincode" id="pincode" class="form-control"> <br> 
									<input type="submit"  value="search" id="submit" name="action">
							</form> -->
						<div class="bbbootstrap">
							<div class="container">
								<form action="TransporterSearchController1" method="post">
									<span role="status" aria-live="polite"class="ui-helper-hidden-accessible"></span>
									 <input type="text"id="Form_Search" value="" placeholder="Enter Pincode" role="searchbox" class="InputBox " autocomplete="off"name="pincode" id="pincode" maxlength="6" minlength="6" required> 
										<input type="submit" id="Form_Go" class="Button" value="GO" name="action">
								</form>
							</div>
						</div>
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>id</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>View Profile</th>
								</tr>
							</thead>
							<%
								for (int i = 0; i < transporters.size(); i++) {
							%>
							<form method="post" action="ViewTransporterController">
								
									<input type="text" value="<%= transporters.get(i).getTransporterID() %>" name="trans_id" hidden="true"/>
									<tr>
									<td><%=transporters.get(i).getTransEmail()%></td>
									<td><%=transporters.get(i).getTransFirstName()%></td>
									<td><%=transporters.get(i).getTransLastName()%></td>
									<td><input type="submit" name="t_viewP" value="View" class="Button" id="t_viewP"></td>
									</tr>
							</form>
							<%
								}
							%>
						</table>
					</div>


				</section>


				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<jsp:include page="script.jsp"></jsp:include>
</body>
</html>