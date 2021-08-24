<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.DAO.DAO_AREA_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_AREA_FILE" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="HEAD.jsp"></jsp:include>
<% 
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN").forward(request, response);
}
%>
<%
	BEAN_AREA_FILE one = (BEAN_AREA_FILE)request.getAttribute("area");
%>
<div id="right-panel" class="right-panel">
	         <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    		<li><a href="HOME_CONTROL">Dashboard</a> </li>
                    		<li><a class="nav-link" href="HOME_CONTROL?page=View Profile"><i class="fa fa- user"></i>My Profile</a></li>
                            <li><a href="HOME_CONTROL?page=Add Category">Add Category</a></li>
                            <li><a href="HOME_CONTROL?page=Add Sub Category">Add Sub Category</a></li>
                            <li><a href="HOME_CONTROL?page=Add Area">Add Area</a></li>
                            <li><a href="HOME_CONTROL?page=View Category">View Category</a></li>
                            <li><a href="HOME_CONTROL?page=View Sub Category">View Sub Category</a></li>
                            <li class="active"><a href="HOME_CONTROL?page=View Area">View Area</a></li>
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
         <div class="breadcrumbs">
            <div class="breadcrumbs-inner">
                <div class="row m-0">
                    <div class="col-sm-4">
                        <div class="page-header float-left">
                            <div class="page-title">
                                <h1>Dashboard</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            <div class="page-title">
                                <ol class="breadcrumb text-right">
                                    <li><a href="#">Dashboard</a></li>
                                    <li class="active">Update Area</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="content">
            <div class="animated fadeIn">
                <div class="row">
                <div class="col-lg-12">
                <div class="card">
                    <div class="card-header" style="text-align:center;">
                        <strong class="card-title">UPDATE_AREA TABLE</strong>
                    </div>
                    <div class="card-body align-content-center">
                        <table class="table table-bordered table-dark" >
                                <thead class="thead-dark">
                                
									<tr style="background-color: white;">
										<th style="text-align: center;">
											AREA_ID
										</th>
										<th style="text-align: center;">
											AREA_NAME
										</th>
										<th colspan="2" style="text-align: center;">
											CHANGES
										</th>
									</tr>

                              </thead>
                              <tbody>
                                	
									<tr>
											<form action="AREA_ONE" method="post">
										<td style="border-color: blue;text-align: center;">
											
											<input type="number" name="id1" id="id1" value=<%=one.GET_AREA_ID()%>>
											
										</td>
									
										<td style="border-color: blue;text-align: center;">
											
												<input type="text" name="name1" id="name1" value=<%=one.GET_AREA_NAME()%>>
											
										</td>
										<td style="border-color: blue;text-align: center;">
									
												<input type="submit" name="action" value="save">
											</form>
										</td> 
								
									</tr>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
                    
        </div>
    </div><!-- .animated -->
</div><!-- .content -->
<div class="clearfix"></div>
	<jsp:include page="FOOTER.jsp"></jsp:include>  
</div>
 <jsp:include page="SCRIPT.jsp"></jsp:include> 
</html>