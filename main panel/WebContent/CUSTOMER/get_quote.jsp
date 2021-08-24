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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/sweetalert.min.js"></script>
<script type="text/javascript">
$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
   
    $('#txtDate').attr('min', maxDate);
})


$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
   
    $('#txtDate1').attr('min', maxDate);
})
</script>
<jsp:include page="head.jsp"></jsp:include>
<title>GET QUOTE</title>
<body>
<%
if(null == session.getAttribute("id"))
{
	 response.setContentType("text/html"); PrintWriter pw = response.getWriter();
	  pw.println("<script>");
	  pw.println("var name=\"page=Get Quote\"; \r\n" + 
		  		"		window.location.replace(\"LOGIN_CONTROL_CUSTOMER?name=\"+name); ");
	  pw.println("</script>");
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
						
						<!-- page-banner-section 
					================================================== -->
						<section class="page-banner-section">
							<div class="container">
								<div class="row">
									<div class="col-sm-6">
										<h2>Get Quote</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="LOGIN_CONTROL_CUSTOMER?page=Home">Home</a></li>
											<li>Get Quote</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->


				<section class="quote-section">
						<%
							int id=(Integer) session.getAttribute("id");

							BEAN_LOG_FILE one = DAO_LOG_FILE.getUserById(id);
						%>
					<div class="container">
						<div class="row">
							<div class="col-sm-6">
								<div class="quote-box">
									<h1>Get Free Quote From Transporter</h1>

									<form id="contact-form" action="CONTROLLER_QUOTE_FILE" method="post" enctype="multipart/form-data">
										<input class="form-control" name="cust_mail" id="cust_mail" type="hidden" value=<%=one.GET_USER_NAME()%> readonly>
										
										<label class="form-control">CATEGORY:</label>
										<select class="form-control" id="category_id" name="category_id">
											<option disabled="" value="" selected="">Select Category</option>
			                            	   <%
			                            	   	Connection con =CONNECT_FILE.sqlConnection();
			                                	    Statement st = con.createStatement();
			                                	    ResultSet rs = st.executeQuery("select * from cat");
			                                  	  while (rs.next()) {
			                            	   %>
			                              			  <option value="<%=rs.getInt("category_id")%>"><%=rs.getString("category_name")%></option>
			                              	  <%
			                                   	 }
			                              	  %>
                              		  </select>
					           	             <label class="form-control">SUB CATEGORY:</label> 
					           	              <select class="form-control" name="sub_category_id" id="sub_category_id">
                                				<option>Select Sub Category</option>
                            					</select>  
						                   <label class="form-control">Collection Location:</label>
										<select name="source_id" class="form-control">
			                                <%
													DAO_AREA_FILE ed1 = new DAO_AREA_FILE();
													List<BEAN_AREA_FILE> list1 =ed1.getAllInfo();
			
													for(BEAN_AREA_FILE info: list1)
													{
											%>
					                        <option class="form-control" value="<%=info.GET_AREA_ID() %>" required> <%= info.GET_AREA_NAME() %>
					                        </option>
					                        <%
													}
					                   		 %>
					                        
					                        </select>
					                        <label class="form-control" >Delivery Location:</label>
										<select name="destination_id" class="form-control">
			                                <%
													DAO_AREA_FILE ed2 = new DAO_AREA_FILE();
													List<BEAN_AREA_FILE> list2 =ed2.getAllInfo();
			
													for(BEAN_AREA_FILE info: list2)
													{
											%>
					                        <option class="form-control" value="<%=info.GET_AREA_ID() %>" required> <%= info.GET_AREA_NAME() %>
					                        </option>
					                        <%
															}
					                   		 %>
					                        </select>
					                        <label class="form-control">Address*</label>
											<input type="text" placeholder="Address line 1" class="form-control"  name="add_1"  required>
											<input type="text" placeholder="Address line 2" class="form-control" name="add_2" required>
	
										<label class="form-control">MESSAGE:</label>
										<textarea class="form-control" name="message" id="message" placeholder="Message" rows="4" cols="50"></textarea>
										
										   <label for="From">When can your load can be collected?:</label>
											<input type="date" id="txtDate" name="from">
											<label for="To">When can your need your shipment delivered?:</label>
											<input type="date" id="txtDate1" name="to"><br> 
										<input type="submit" name="action" value="submit" id="submit" onclick="loa()">
										<div id="msg" class="message"></div>
									</form>
								</div>

							</div>
						</div>
					</div>
					 <div style="color:red;" id="error"></div><!-- error message will display here. --->
            		<div id="success"></div><!-- output message will display here. --->

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
</html>

<script>
    $(document).ready(function () {
        $("#category_id").on("change", function () {
            var category_id = $("#category_id").val();//id of country select box of index.jsp page;
                $.ajax({
                    url: "sub_category.jsp",//your jsp page name
                    data: {category_id: category_id},//sending request to state.jsp page.
                    method: "POST",//HTTP method.
                    success: function (data)
                    {
                        $("#sub_category_id").html(data);//output or response will display in state select box.
                    }
                });
        });
    });
</script>

