<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_NOTIFICATION_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_NOTIFICATION_FILE" %>
      <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<title>NOTIFICATION</title>
<%
	if(session.isNew())
	{
		 response.setContentType("text/html"); PrintWriter pw = response.getWriter();
		  pw.println("<script>");
		  pw.println("var name=\"page=Notification\"; \r\n" + 
			  		"		window.location.replace(\"LOGIN_CONTROL_CUSTOMER?name=\"+name); ");
		  pw.println("</script>");
	}
%>
<body>

	<!-- Container -->
	<div id="container">

		<!-- Header
		    ================================================== -->
			<jsp:include page="login_head.jsp"></jsp:include>
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
										<h2>Notifications</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Notifications</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section --> 
				
				
				<!-- contact section 
					================================================== -->
				<section class="contact-section" style="overflow-x: auto;">
					<div class="container">
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>NOTIFICATION_ID</th>
                                            <th>TRANSPORTER_EMAIL</th>
                                            <th>REPLY</th>
                                            <th>DATE</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
										DAO_NOTIFICATION_FILE ed = new DAO_NOTIFICATION_FILE();
										List<BEAN_NOTIFICATION_FILE> list =ed.getAllInfo();

										for(BEAN_NOTIFICATION_FILE info: list)
										{
									%> 
	 
									<tr>
										<td>
											<% out.println(info.GET_NOTIFICATION_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_TRANS_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_REPLY()); %>
										</td>
										<td>
											<% out.println(info.GET_DATE_TIME()); %>
										</td>
										
										<%
											}
										%>
										
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