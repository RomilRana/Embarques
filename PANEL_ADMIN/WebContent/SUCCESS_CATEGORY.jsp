<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.DAO.DAO_CATEGORY_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_CATEGORY_FILE" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="">
<% 
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN.jsp").forward(request, response);
}
%>
<jsp:include page="HEAD.jsp"></jsp:include>
<title>VIEW CATEGORIES</title>
<div id="right-panel" class="right-panel">
	         <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    		<li><a href="HOME_CONTROL">Dashboard</a> </li>
                    		<li><a href="HOME_CONTROL?page=View Profile">My Profile</a></li>
                            <li><a href="HOME_CONTROL?page=Add Category">Add Category</a></li>
                            <li><a href="HOME_CONTROL?page=Add Sub Category">Add Sub Category</a></li>
                            <li><a href="HOME_CONTROL?page=Add Area">Add Area</a></li>
                            <li class="active"><a href="HOME_CONTROL?page=View Category">View Category</a></li>
                            <li><a href="HOME_CONTROL?page=View Sub Category">View Sub Category</a></li>
                            <li><a href="HOME_CONTROL?page=View Area">View Area</a></li>
                            <li><a href="HOME_CONTROL?page=View Customer">View Customer</a></li>
                            <li><a href="HOME_CONTROL?page=View Transporter">View Transporter</a></li>
                            <li><a href="HOME_CONTROL?page=View Unpaid Transporter">View Unpaid Transporter</a></li>
                                                        <li><a href="HOME_CONTROL?page=Feedback">Feedback</a></li>
                            <li><a href="HOME_CONTROL?page=Login">Logout</a></li>
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
                                    <li class="active">CATEGORY_TABLE</li>
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

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">CATEGORY TABLE</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered table-dark">
                                    <thead>
                                        <tr>
                                            <th>CATEGORY_ID</th>
                                            <th>CATEGORY_NAME</th>
                                            <th>DELETE</th>
                                            <th>EDIT</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                           <%
										DAO_CATEGORY_FILE ed = new DAO_CATEGORY_FILE();
										List<BEAN_CATEGORY_FILE> list =ed.getAllInfo();

										for(BEAN_CATEGORY_FILE info: list)
										{
									%> 
	 
									<tr>
										<td>
											<% out.println(info.GET_CATEGORY_ID()); %>
										</td>
										<td>
											<% out.println(info.GET_CATEGORY_NAME()); %>
										</td>

										<td>
											<form action="CATEGORY_ONE" method="post">
												<input type="hidden" name="id" value="<%=info.GET_CATEGORY_ID()%>">
												 <input type="submit" name="action" value="delete">
											</form>
										</td>
										
										<td>
											<form action="CATEGORY_ONE" method="post">
												<input type="hidden" name="id" value="<%=info.GET_CATEGORY_ID()%>">
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