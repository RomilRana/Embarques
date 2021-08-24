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
	
<!doctype html>
<html lang="en" class="no-js">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<jsp:include page="head.jsp"></jsp:include>
<body>
<%
	if(session.isNew())
	{
		request.getRequestDispatcher("login.jsp").forward(request, response);
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
										<h2>Search Transporter</h2>
									</div>
									<div class="col-sm-6">
										<ul class="page-depth">
											<li><a href="index_1.jsp">Home</a></li>
											<li>Search Transporter</li>
										</ul>
									</div>
								</div>
							</div>
						</section>
				<!-- End page-banner section -->

				<section class="quote-section">
					<div class="container">
						<div class="row">
							<div class="col-sm-6">
								<div class="quote-box">
									<h1>Free quote to contact us</h1>

									<form id="contact-form" action="CONTROLLER_QUOTE_FILE" method="post" enctype="multipart/form-data">
									
										
										<label class="form-control">AREA AREA:</label>
										<select class="form-control" id="pincode" name="pincode">
											<option disabled="" value="" selected="">Select Area</option>
			                            	   <%
			                            	   	Connection con =CONNECT_FILE.sqlConnection();
			                                	    Statement st = con.createStatement();
			                                	    ResultSet rs = st.executeQuery("select * from area_tab");
			                                  	  while (rs.next()) {
			                            	   %>
			                              			  <option value="<%=rs.getInt("pincode")%>"><%=rs.getString("area_name")%></option>
			                              	  <%
			                                   	 }
			                              	  %>
                              		  </select>
					           	        
										<table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>TRANSPORTER_EMAIL</th>
                                            <th>PINCODE</th>
                                            <th>SEE</th>
                                        </tr>
                                    </thead>
                                    <tbody id="trans_id">
							
									
                                    </tbody>
                                </table><br>
									</form>
								</div>

							</div>
						</div>
					</div>

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
<script>
    $(document).ready(function () {
        $("#pincode").on("change", function () {
            var pincode = $("#pincode").val();//id of country select box of index.jsp page;
                $.ajax({
                    url: "search.jsp",//your jsp page name
                    data: {pincode: pincode},//sending request to state.jsp page.
                    method: "POST",//HTTP method.
                    success: function (data)
                    {
                        $("#trans_id").html(data);//output or response will display in state select box.
                        
                        
                        var t_mail = $("#t_mail").val();//id of country select box of index.jsp page;
                        
                        $.ajax({
                            url:"CONTROLLER_SEARCH_FILE",//your servlet or jsp page name.
                            method:"POST",//HTTP method.
                            data:{t_mail:t_mail},//sending request to DisplayText.java page.
                            success:function(data)
                            {
                                $("#form").trigger("reset");//this will reset the form.
                            }
                        });
                    }
                });
        });
    });
</script>
<!-- <!-- 

<script type="text/javascript">
$(document).ready(function () {
$("#gs").on("click",function () {
    var t_mail = $("#t_mail").val();//id of country select box of index.jsp page;
    
    $.ajax({
        url:"CONTROLLER_SEARCH_FILE",//your servlet or jsp page name.
        method:"POST",//HTTP method.
        data:{t_mail:t_mail},//sending request to DisplayText.java page.
        success:function(data)
        {
            $("#form").trigger("reset");//this will reset the form.
        }
    });
	});
});
</script> --> -->
</html>
