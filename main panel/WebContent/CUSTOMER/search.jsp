<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="COM.CUSTOMER.CONNECT.CONNECT_FILE" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
            <%

                int area_id = Integer.parseInt(request.getParameter("pincode"));
            	Connection con =CONNECT_FILE.sqlConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from trans_table where pincode="+ area_id+" ");
                while (rs.next()) {
            %>  
             <td><input type="text" name="t_mail" value="<%=rs.getString("trans_email")%>" id="t_mail">></td>
             <td><input type="text" name="t_pin" value="<%=rs.getString("pincode")%>" id="t_pin"></td>
          
            
            
            <%
                }
            %>

    </body>
</html>
