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

                int category_id = Integer.parseInt(request.getParameter("category_id"));
            	Connection con =CONNECT_FILE.sqlConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from sub_cat where category_id="+ category_id+" ");
                while (rs.next()) {
            %>
            <option value="<%=rs.getInt("sub_category_id")%>"><%=rs.getString("sub_category_name")%></option>
            <%
                }
            %>
        </select>

    </body>
</html>