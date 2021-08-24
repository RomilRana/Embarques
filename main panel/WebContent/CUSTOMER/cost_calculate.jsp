<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.CUSTOMER.DAO.DAO_QUOTE_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE" %>
<!doctype html>
<html lang="en" class="no-js">
<jsp:include page="head.jsp"></jsp:include>
<%
	if(session.isNew())
	{
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>
<script type="text/javascript">
function multiplyBy()
{
        height = document.getElementById("height").value;
        width = document.getElementById("width").value;
        depth = document.getElementById("depth").value;
        weight = document.getElementById("weight").value;
        document.getElementById("result").innerHTML = height * width * depth * weight;
}
</script>
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
                
					<div class="container">
                                            <label> height (cm): </label>
                                            <input type="text" placeholder="" class="form-control" id="height">                                        
                                        
                                        
                                            <label> width (cm): </label>
                                           	<input type="text" placeholder="" class="form-control" id="width">                                         
                                        
                                        
                                           <label> depth (cm): </label>
                                          	<input type="text" placeholder="" class="form-control" id="depth">                                        
                                       
                                      
                                            <label> weight (kg): </label>
                                            <input type="text" placeholder="" class="form-control" id="weight">                                        
                                      
                                        
                                            <label> location: </label>
                                            <input type="text" placeholder="From" class="form-control">
                                              
                                            <input type="text" placeholder="To" class="form-control">
                                            
                                            <input type="button" onClick="multiplyBy()" Value="Check" >
                                         
                                            <p>The Result is : <br>
											<span id = "result"></span>
                            </div>
				 
                                                 
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
