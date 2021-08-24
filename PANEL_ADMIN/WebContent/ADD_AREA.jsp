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
<title>ADD AREA</title>
<body>
<div id="right-panel" class="right-panel">
	         <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    		<li><a href="HOME_CONTROL">Dashboard</a> </li>
                    		<li><a href="HOME_CONTROL?page=View Profile">My Profile</a></li>
                            <li><a href="HOME_CONTROL?page=Add Category">Add Category</a></li>
                            <li><a href="HOME_CONTROL?page=Add Sub Category">Add Sub Category</a></li>
                            <li class="active"><a href="HOME_CONTROL?page=Add Area">Add Area</a></li>
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
        <div class="container">
            <div class="login-content">
                <div class="login-logo" style="!important margin:0px;">
                    <a href="INDEX.jsp">
                        <img class="align-content" src="RESOURCES/images/index2.png" alt="" HEIGHT="173" width="800">
                    </a>
                </div>
                <div class="login-form">
                    <form action="AREA_ONE" method="post">
               			<div class="form-group">
                            <label>PIN CODE</label>
                            <input type="text" id="area_id" name="area_id" class="form-control" placeholder="PIN_CODE" maxlength="6" minlength="6" required>
                        </div>
                        <div class="form-group">
                            <label>AREA NAME</label>
                            <input type="text" id="area_name" name="area_name" class="form-control" placeholder="Area Name" required>
                        </div>
                        
                        <button type="submit" name="action" value="submit" class="btn btn-success btn-flat m-b-30 m-t-30">ADD</button>
                    
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