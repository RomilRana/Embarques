<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.TRANSPORTER.DAO.DAO_TRANSPORTER_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_USER_FILE" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>

<body onload="document.registration.first_name.focus();">

<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER").forward(request, response);
}
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
				<section class="contact-section">
					<div class="container">
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>USER_ID</th>
                                            <th>FIRST_NAME</th>
                                            <th>LAST_NAME</th>
                                            <th>EMIAL_ID</th>
                                            <th>USER_PASSWORD</th>
                                            <th>CONTACT_NO.</th>
                                            <th>DELETE</th>
                                            <th>EDIT</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
										DAO_TRANSPORTER_FILE ed = new DAO_TRANSPORTER_FILE();
										List<BEAN_USER_FILE> list =ed.getAllInfo();

										for(BEAN_USER_FILE info: list)
										{
									%> 
	 
									<tr>
										<td>
											<% out.println(info.GET_USER_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_FIRST_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_LAST_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_USER_NAME()); %>
										</td>
										<td>
											<% out.println(info.GET_USER_PASSWORD()); %>
										</td>
										<td>
											<% out.println(info.GET_CONTACT()); %>
										</td>
										

										<td>
											<form action="USER_ONE" method="post">
												<input type="hidden" name="id" value="<%=info.GET_USER_ID()%>">
												 <input type="submit" name="action" value="delete">
											</form>
										</td>
										
										<td>
											<form action="USER_ONE" method="post">
												<input type="hidden" name="id" value="<%=info.GET_USER_ID()%>">
												 <input type="submit" name="action" value="edit">
											</form>
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
<!-- Revolution slider -->
				<jsp:include page="script.jsp"></jsp:include>
<!-- End Container -->
</body>
</html>