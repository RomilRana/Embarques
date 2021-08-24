<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.DAO.DAO_USER_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_USER_FILE" %>
    <%@page import="COM.DAO.DAO_USER_FILE" %>
    
        <%@page import="COM.BEAN.BEAN_TRANSPORTER_FILE" %>
    <%@page import="COM.DAO.DAO_TRANSPORTER_FILE" %>
     <%@page import="COM.DAO.DAO_TRANSPORTER_FILE" %>
         <%@page import="COM.DAO.DAO_PACKAGE_FILE" %>
           <%@page import="COM.DAO.DAO_QUOTE_FILE" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<jsp:include page="HEAD.jsp"></jsp:include>
<title>EMBARQUES</title>
<script>
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
</script> 

<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN.jsp").forward(request, response);
}
%>
<%
DAO_USER_FILE d1 = new DAO_USER_FILE();
int count1 = d1.getCount();

DAO_TRANSPORTER_FILE d2 = new DAO_TRANSPORTER_FILE();
int count2 = d2.getCount();

DAO_PACKAGE_FILE d3 = new DAO_PACKAGE_FILE();
int count3 = d3.getCount();

DAO_QUOTE_FILE d4 = new DAO_QUOTE_FILE();
int count4 = d4.getCount();
%>

          <!-- Content -->
       <!-- Right Panel -->
    <div id="right-panel" class="right-panel">
  
<aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    		<li class="active"><a href="HOME_CONTROL">Dashboard</a> </li>
                    		<li><a class="nav-link" href="HOME_CONTROL?page=View Profile"><i class="fa fa- user"></i>My Profile</a></li>
                            <li><a href="HOME_CONTROL?page=Add Category">Add Category</a></li>
                            <li><a href="HOME_CONTROL?page=Add Sub Category">Add Sub Category</a></li>
                            <li><a href="HOME_CONTROL?page=Add Area">Add Area</a></li>
                            <li><a href="HOME_CONTROL?page=View Category">View Category</a></li>
                            <li><a href="HOME_CONTROL?page=View Sub Category">View Sub Category</a></li>
                            <li><a href="HOME_CONTROL?page=View Area">View Area</a></li>
                            <li><a href="HOME_CONTROL?page=View Customer">View Customer</a></li>
                            <li><a href="HOME_CONTROL?page=View Transporter">View Transporter</a></li>
                            <li><a href="HOME_CONTROL?page=View Unpaid Transporter">View Unpaid Transporter</a></li>
                                                        <li><a href="HOME_CONTROL?page=Feedback">Feedback</a></li>
                            <li><a class="nav-link" href="HOME_CONTROL?page=Login"><i class="fa fa-power -off"></i>Logout</a></li>
                </ul>
            </div>
        </nav>
    </aside> 
      	         <jsp:include page="RIGHT_HEADER.jsp"></jsp:include> 
        <!-- Content -->
        <div class="content" >
        <body >

</nav>
            <!-- Animated -->
            <div class="animated fadeIn">
            
               
                <div class="row">


                     <div class="col-sm-6 col-lg-6">
                        <div class="card text-white bg-flat-color-3">
                            <div class="card-body">
                                <div class="card-left pt-1 float-left">
                                    <h3 class="mb-0 fw-r">
                                        <span class="count"><%out.print(count2); %></span>
                                    </h3>
                                    <p class="text-light mt-1 m-0">Total Transporter</p>
                                </div><!-- /.card-left -->

                                <div class="card-right float-right text-right">
                                    <i class="icon fade-5 icon-lg pe-7s-users"></i>
                                </div><!-- /.card-right -->

                            </div>

                        </div>
                    </div>
                    <!--/.col-->
                    <div class="col-sm-6 col-lg-6">
                        <div class="card text-white bg-flat-color-3">
                            <div class="card-body">
                                <div class="card-left pt-1 float-left">
                                    <h3 class="mb-0 fw-r">
                                        <span class="count"><%out.print(count1); %></span>
                                    </h3>
                                    <p class="text-light mt-1 m-0">Total Customer</p>
                                </div><!-- /.card-left -->

                                <div class="card-right float-right text-right">
                                    <i class="icon fade-5 icon-lg pe-7s-users"></i>
                                </div><!-- /.card-right -->

                            </div>

                        </div>
                    </div>
                    
                     <div class="col-sm-6 col-lg-6">
                        <div class="card text-white bg-flat-color-1">
                            <div class="card-body">
                                <div class="stat-widget-one">
                                    <div class="stat-icon dib"><i class="ti-layout-grid2 text-warning border-warning"></i></div>
                                    <div class="stat-content dib">
                                         <h3 class="mb-0 fw-r">
                                        <span class="count"><%out.print(count4); %></span>
                                    </h3>
                                    <p class="text-light mt-1 m-0">Requirements</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-6 col-lg-6">
                        <div class="card text-white bg-flat-color-1">
                            <div class="card-body">
                                <div class="card-left pt-1 float-left">
                                    <h3 class="mb-0 fw-r">
                                        <span class="count"><%out.print(count3); %></span>
                                    </h3>
                                    <p class="text-light mt-1 m-0">Packages</p>
                                </div><!-- /.card-left -->

                                <div class="card-right float-right text-right">
                                    <i class="icon fade-5 icon-lg pe-7s-cart"></i>
                                </div><!-- /.card-right -->

                            </div>

                        </div>
                    </div>
                    <!--/.col-->
                    
                   

                    </div>
                </div><!-- .row -->
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">NEW CUSTOMER TABLE</strong>
                            </div>
                            <div class="card-body">
                                <table class="table table-striped table-bordered table-dark">
                                    <thead>
                                        <tr>
                                            <th>CUSTOMER_ID</th>
                                            <th>CUSTOMER_NAME</th>
                                    </thead>
                                    <tbody>
                                           <%
										DAO_USER_FILE ed = new DAO_USER_FILE();
										List<BEAN_USER_FILE> list =ed.getLatestUser();

										for(BEAN_USER_FILE info: list)
										{
									%> 
	 
									<tr>
										<td>
											<% out.println(info.GET_USER_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_USER_NAME()); %>
										</td>
								
										<%
											}
										%> 
									</tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                </div>
                
                
                 <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">NEW TRANSPORTER TABLE</strong>
                            </div>
                            <div class="card-body">
                                <table class="table table-striped table-bordered table-dark">
                                    <thead>
                                        <tr>
                                            <th>TRANSPORTER_ID</th>
                                            <th>TRANSPORTER_NAME</th>
                                    </thead>
                                    <tbody>
                                           <%
										DAO_TRANSPORTER_FILE ed1 = new DAO_TRANSPORTER_FILE();
										List<BEAN_TRANSPORTER_FILE> list1 =ed1.getLatestTransporter();

										for(BEAN_TRANSPORTER_FILE info: list1)
										{
									%> 
	 
									<tr>
										<td>
											<% out.println(info.GET_USER_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_USER_NAME()); %>
										</td>
								
										<%
											}
										%> 
									</tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


            </div>
           
             <div class="clearfix"></div>
            <jsp:include page="FOOTER.jsp"></jsp:include>  
        </div>
        </div>
              
        <jsp:include page="SCRIPT.jsp"></jsp:include>  
</body>
</html>