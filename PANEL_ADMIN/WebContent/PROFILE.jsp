<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.DAO.DAO_LOG_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_LOG_FILE" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="">
<jsp:include page="HEAD.jsp"></jsp:include>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN.jsp").forward(request, response);
}
%>
<title>PROFILE</title>
<div id="right-panel" class="right-panel">
	                  <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    		<li><a href="HOME_CONTROL">Dashboard</a> </li>
                    		<li class="active"><a href="HOME_CONTROL?page=View Profile">My Profile</a></li>
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
                                    <li class="active">PROFILE</li>
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
                                <strong class="card-title">PROFILE TABLE</strong>
                            </div>
                            <div class="card-body">
                                <table class="table table-striped table-bordered" >
                                    <tbody>
										 <%
												int id=(Integer) session.getAttribute("id");
	
												BEAN_LOG_FILE one = DAO_LOG_FILE.getAdminById(id);
										%>
										<tr>
										<th style="background-color: black;color: white;border-bottom-color: white;">EMIAL_ID</th>
                                            <td>
											<input type="text" name="id1" id="id1" value=<%=one.GET_ADMIN_NAME()%> readonly>
											</td>
										</tr>
										
										<tr> 
										<th style="background-color: black;color: white;border-bottom-color: white;">FIRST_NAME</th>
										<td>
											<input type="text" name="id2" id="id2" value=<%=one.GET_FIRST_NAME()%> readonly>
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: black;color: white;border-bottom-color: white;">LAST_NAME</th>
										<td>
											<input type="text" name="id3" id="id3" value=<%=one.GET_LAST_NAME()%> readonly>
										</td>
										</tr>
										
										<tr>
										
										<th style="background-color: black;color: white;border-bottom-color: white;">CONTACT</th>
										<td>
											<input type="text" name="id4" id="id4" value=<%=one.GET_CONTACT()%> readonly>
										</td>
										</tr>
										
										<tr>
										   <th style="background-color: black;color: white;border-bottom-color: white;">EDIT</th>
										  <td>
											<form action="PROFILE_ADMIN" method="post">
												<input type="hidden" name="id" value="<%=one.GET_ADMIN_ID()%>" readonly>
												<input type="submit" name="action" value="edit">
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