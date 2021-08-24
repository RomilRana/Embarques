<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="HEAD.jsp"></jsp:include>
<body>
<div id="right-panel" class="right-panel">
	         <jsp:include page="HEADER.jsp"></jsp:include>
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
                                    <li class="active">FORGET</li>
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
                    <form>
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" class="form-control" placeholder="Email">
                        </div>
                        <button type="submit" class="btn btn-primary btn-flat m-b-15">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
         <div class="clearfix"></div>
      <jsp:include page="FOOTER.jsp"></jsp:include> 
    </div>

                 <jsp:include page="SCRIPT.jsp"></jsp:include> 
</body>
</html>