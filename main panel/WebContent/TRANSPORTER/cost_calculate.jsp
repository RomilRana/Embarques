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
<jsp:include page="head.jsp"></jsp:include>

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
                                    
                                    <section class="quote-section">

					<div class="container">
						<div class="row">
							<div class="col-sm-6">
								<div class="quote-box">
									<h1>Cost Calculation</h1>

									<form id="contact-form" action="CONTROLLER_QUOTE_FILE" method="post" enctype="multipart/form-data">
										<label class="form-control">ENTER PRICE PER KM.</label>
										<input class="form-control" name="price" id="price" type="text">
										
										
										 <label class="form-control">SOURCE:</label>
										<select name="source_id" id="source_id" class="form-control">
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
					                        <label class="form-control" >DESTINATION:</label>
										<select name="destination_id" id="destination_id" class="form-control">
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
					                        
					                        </select><br><br>
											
										<label class="form-control">TOTAL</label>
										<input class="form-control" name="total" id="total" type="text" readonly>
																			
										<input type="submit" name="action" value="submit" id="submit" onclick="loa()">
										<div id="msg" class="message"></div>
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
        $("#source_id").on("change", function () {
            var source_id = $("#source_id").val();//id of country select box of index.jsp page;
                $.ajax({
                    url: "cal.jsp",//your jsp page name
                    data: {source_id:source_id},//sending request to state.jsp page.
                    method: "POST",//HTTP method.
                    success: function (data)
                    {
                        
                    }
                });
        });
        
        $("#destination_id").on("change", function () {
            var destination_id = $("#destination_id").val();//id of country select box of index.jsp page;
                $.ajax({
                    url: "cal.jsp",//your jsp page name
                    data: {destination_id:destination_id},//sending request to state.jsp page.
                    method: "POST",//HTTP method.
                    success: function (data)
                    {
                        
                    }
                });
        });
    });
</script>
</html>
