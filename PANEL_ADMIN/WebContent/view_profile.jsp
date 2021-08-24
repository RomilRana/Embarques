<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.DAO.DAO_PROFILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_PROFILE_FILE" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="">
<jsp:include page="HEAD.jsp"></jsp:include>
<% 
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN").forward(request, response);
}
%>
<title>VIEW PROFILE</title>
<div id="right-panel" class="right-panel">
	         <jsp:include page="HEADER.jsp"></jsp:include>
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
                                <table id="bootstrap-data-table" class="table table-striped table-bordered table-dark">
                                    <thead>
                                        <tr>
                                            <th>EMIAL_ID</th>
                                            <th>FIRST_NAME</th>
                                            <th>LAST_NAME</th>
                                            <th>CONTACT</th>
                                            <th>EDIT</th>
                                        </tr>
                                    </thead>
                                    <tbody>
										 <tr>
										 <%
										 	HttpSession ses = request.getSession(false);
											String uname = ses.getAttribute("email_a").toString();
												
											DAO_PROFILE d1 = new DAO_PROFILE();
											BEAN_PROFILE_FILE one = d1.GET_BY_ID(uname);
										%>
										 <td>
											<input type="text" name="id1" id="id1" value=<%=one.GET_USER_NAME()%> readonly>
										</td> 
										
										<td>
											<input type="text" name="id2" id="id2" value=<%=one.GET_FIRST_NAME()%> readonly>
										</td>
										
										<td>
											<input type="text" name="id3" id="id3" value=<%=one.GET_LAST_NAME()%> readonly>
										</td>
										
										<td>
											<input type="text" name="id4" id="id4" value=<%=one.GET_CONTACT()%> readonly>
										</td>
										
										<td>
											<form action="PROFILE_ADMIN" method="post">
												<input type="hidden" name="id" value="<%=one.GET_USER_ID()%>" readonly>
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