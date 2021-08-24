
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" id="file" name="file1" accept="image/*"  multiple="muliple" required/><br>
            <input type="submit"/>
           <br><br> ${requestScope.message}
        </form>
    </body>
</html>