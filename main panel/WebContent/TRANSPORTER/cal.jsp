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
        <select class="form-control" name="sub_category_id" id="sub_category_id">
            <option>Select Sub Category</option>
            <%

            	int source_id = Integer.parseInt(request.getParameter("source_id"));
        		int destination_id = Integer.parseInt(request.getParameter("destination_id"));
            	Connection con =CONNECT_FILE.sqlConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from cost_table where source_id="+source_id+" ");
                while (rs.next()) {
            %>
            
            <%
                }
            %>
        </select>

    </body>
</html>