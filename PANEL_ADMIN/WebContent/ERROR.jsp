<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function alertUser(msg) {
alert(msg);

history.pushState(null, null, location.href);
window.onpopstate = function () {
    history.go(1);
};
} 
</script>
</head>
<jsp:include page="HEAD.jsp"></jsp:include>
<body onload="alertUser('PLEASE ENTER VALID DETAILS!')" >
<div id="right-panel" class="right-panel">
	        
 <div class="sufee-login d-flex align-content-center flex-wrap"> 
        <div class="container">
            <div class="login-content">
                <div class="login-logo" style="!important margin:0px;">
                    <a href="INDEX.jsp">
                        <img class="align-content" src="RESOURCES/images/index2.png" alt="" HEIGHT="173" width="800">
                    </a>
                </div>
                <div class="login-form">
                    <form method="post" action="CHECK.jsp">
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" class="form-control" placeholder="Email" name="email_id" required>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" placeholder="Password" name="password" required>
                            
                        </div>
                        <!-- <input type="submit" value="Login" id="login" name=login" class="btn btn-success btn-flat m-b-30 m-t-30"> -->
                        <button type="submit" class="btn btn-success btn-sm">Submit</button>
                    </form>
                    
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>