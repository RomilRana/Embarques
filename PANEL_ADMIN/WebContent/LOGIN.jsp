<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="HEAD.jsp"></jsp:include>
<title>LOGIN</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
</script> 

<body class="bg-dark">

    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-logo">
                    <a href="index.html">
                        <img class="align-content" src="RESOURCES/images/index2.png" alt="">
                    </a>
                </div>
                <div class="login-form">
                    <form method="post" action="ADMIN_LOG">
                        <div class="form-group">
                            <label>Email address</label>
                             <input type="text" class="form-control"  name="admin_email" id="admin_email">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="admin_password" id="admin_password">
                        </div>

                        <button type="submit" class="btn btn-success btn-flat m-b-30 m-t-30" name="action" value="submit">Sign in</button>
                     
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
</html> 

