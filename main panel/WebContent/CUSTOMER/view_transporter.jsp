<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="java.io.PrintWriter" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>

<body>
<%
	BEAN_LOG_FILE one = (BEAN_LOG_FILE)request.getAttribute("trans");
%>

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

					
				
				
				<!-- contact section 
					================================================== -->
				<section class="contact-section" style="overflow-x: auto;">
					<div class="container">
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>TRANSPORTER_EMAIL</th>
                                            <th>FIRST_NAME</th>
                                            <th>LAST_NAME</th>
                                            <th>CONTACT</th>
                                        </tr>
                                    </thead>
                                    <tbody>
	 
									<tr>
										<td>
											<% out.println(one.GET_USER_NAME()); %>
										</td>
										<td>
											<% out.println(one.GET_FIRST_NAME()); %>
										</td>
										<td>
											<% out.println(one.GET_LAST_NAME()); %>
										</td>
										<td>
											<% out.println(one.GET_CONTACT()); %>
										</td>
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