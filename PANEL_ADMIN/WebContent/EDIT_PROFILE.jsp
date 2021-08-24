<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="HEAD.jsp"></jsp:include>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN.jsp").forward(request, response);
}
%>
<title>EDIT PROFILE</title>
<body>
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
	         
    <div class="sufee-login d-flex align-content-center flex-wrap">
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
                                    <li class="active">EDIT Profile</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="login-content">
                <div class="login-logo" style="!important margin:0px;">
                    <a href="INDEX.jsp">
                        <img class="align-content" src="RESOURCES/images/index2.png" alt="" HEIGHT="173" width="800">
                    </a>
                </div>
                <div class="login-form">
                    <form action="#" method="post" class="">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                        <input type="text" id="username" name="username" placeholder="Username" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                        <input type="email" id="email" name="email" placeholder="Email" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                        <input type="number" id="mobile" name="mobile" placeholder="Mobile no" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon"><i class="fa fa-asterisk"></i></div>
                                        <input type="password" id="password" name="password" placeholder="Password" class="form-control">
                                    </div>
                                </div>	
                                
                                 <div class="form-group">
                                    <label>PROFILE :</label><img alt="" src="RESOURCES/images/admin.jpg" style="border: 3px solid black;">
                                </div>
                                <div class="form-actions form-group"><button type="submit" class="btn btn-success btn-sm">Submit</button></div>
                            </form>
                </div>
            </div>
        </div>
    </div>
                <jsp:include page="FOOTER.jsp"></jsp:include>  
</div>
        <jsp:include page="SCRIPT.jsp"></jsp:include> 
</body>
</html>