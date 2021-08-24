<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="COM.DAO.DAO_USER_FILE" %>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_USER_FILE" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="">
<jsp:include page="HEAD.jsp"></jsp:include>
<title>NOTIFICATION</title>
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
                                    <li class="active">NOTIFICATION_TABLE</li>
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
                                <strong class="card-title">NOTIFICATION TABLE</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>USER</th>
                                            <th>USER_NAME</th>
                                            <th>MESSAGE</th>
                                            <th>TIME</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<tr>
                                    		<td>
                                    			<img alt="avatar" src="RESOURCES/images/avatar/3.jpg">
                                    		</td>
                                    		<td>
                                    			<span>Rachel Santos</span>
                                    		</td>
                                    		<td>
                                    			<p>Lorem ipsum dolor sit amet, consectetur</p>
                                    		</td>
                                    		<td>
                                    			<span>15 minutes ago</span>
                                    		</td>
                                    	</tr>
                                    	<tr>
                                    		<td>
                                    			<img alt="avatar" src="RESOURCES/images/avatar/4.jpg">
                                    		</td>
                                    		<td>
                                    			<span>Cheryl Wheeler</span>
                                    		</td>
                                    		<td>
                                    			<p>Lorem ipsum dolor sit amet, consectetur</p>
                                    		</td>
                                    		<td>
                                    			<span>15 minutes ago</span>
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
</div>
</html>