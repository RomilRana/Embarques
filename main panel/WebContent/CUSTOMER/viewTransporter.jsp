<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%@page import="java.util.List" %>
    <%@page import="COM.TRANSPORTER.BEAN.BEAN_PROFILE_FILE" %>
    <%@page import="COM.TRANSPORTER.DAO.DAO_PROFILE" %>
     <%@page import="COM.CUSTOMER.DAO.DAO_RATING_FILE" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<title>ABOUT</title>
<script>
	
</script>
<body>
<%
	BEAN_PROFILE_FILE one = (BEAN_PROFILE_FILE)request.getAttribute("specificTranspoter");
%>
<%
int trans_id=one.GET_USER_ID();
DAO_RATING_FILE d1 = new DAO_RATING_FILE();
int five = d1.getFiveCount(trans_id);

DAO_RATING_FILE d3 = new DAO_RATING_FILE();
int four = d3.getFourCount(trans_id);

DAO_RATING_FILE d4 = new DAO_RATING_FILE();
int three = d4.getThreeCount(trans_id);

DAO_RATING_FILE d5 = new DAO_RATING_FILE();
int two = d5.getTwoCount(trans_id);

DAO_RATING_FILE d6 = new DAO_RATING_FILE();
int onee = d6.getOneCount(trans_id);


DAO_RATING_FILE d7 = new DAO_RATING_FILE();
int zero = d7.getZeroCount(trans_id);



DAO_RATING_FILE d8 = new DAO_RATING_FILE();
int count = d8.getCount(trans_id);
int average=0;
if(onee==0 && two==0 && three==0 && four==0 && five==0 && count==0)
{
	average=0;
}
else
{
try
{
	average = average + (5*five + 4*four + 3*three + 2*two + 1*onee) / (five+four+three+two+onee);
}
catch(Exception e)
{
	
}
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
							<h2>View Transporter</h2>
						</div>
						<div class="col-sm-6">
							<ul class="page-depth">
								<li><a href="LOGIN_CONTROL_CUSTOMER?page=About">Home</a></li>
								<li>View Transporter</li>
							</ul>
						</div>
					</div>
				</div>
				</section>
				<!-- End page-banner section -->

				<!-- contact section 
					================================================== -->
				<section id="home-section" class="slider1">
				<div class="container">
					<table id="bootstrap-data-table"
						class="table table-striped table-bordered">

						<tbody>

							<tr>
								<th
									style="background-color: black; color: white; border-bottom-color: white;">EMIAL_ID</th>
								<td><input type="text" name="id1" id="id1"
									value="<%=one.GET_USER_NAME()%>" readonly class="form-control">
								</td>
							</tr>

							<tr>
								<th
									style="background-color: black; color: white; border-bottom-color: white;">FIRST_NAME</th>
								<td><input type="text" name="id2" id="id2"
									value="<%=one.GET_FIRST_NAME()%>" readonly class="form-control">
								</td>
							</tr>

							<tr>

								<th
									style="background-color: black; color: white; border-bottom-color: white;">LAST_NAME</th>
								<td><input type="text" name="id3" id="id3"
									value="<%=one.GET_LAST_NAME()%>" readonly class="form-control">
								</td>
							</tr>

							<tr>

								<th
									style="background-color: black; color: white; border-bottom-color: white;">CONTACT</th>
								<td><input type="text" name="id4" id="id4"
									value="<%=one.GET_CONTACT()%>" readonly class="form-control">
								</td>
							</tr>
							<tr>
							<th
									style="background-color: black; color: white; border-bottom-color: white;">RATING</th>
								<td>
							<span class="product-rating"><%out.println(average); %></span><span>/5</span>
							<div class="stars"> 
						            <%for(int i=0;i<average;i++)
						            	{%><i class="fa fa-star"></i>
						            	<%} %>
						            	<%for(int i=0;i<5-average;i++)
						            	{%><i class="fa fa-star-o"></i>
						            		<%} %>
						            	</div>
						            <div class="rating-text"> <% if(count>1){%><span><%out.println(count); %> Reviews</span><%}else{ %><span><%out.println(count); %> Review</span><%} %> </div>
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
	<!-- Revolution slider -->
	<jsp:include page="script.jsp"></jsp:include>
	<!-- End Container -->
</body>
</html>