<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="COM.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.DAO.DAO_LOG_FILE" %>
<%
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN").forward(request, response);
}
else 
{
	BEAN_LOG_FILE one=null;
	try
	{
		HttpSession ses = request.getSession(false);
		int id=(Integer) ses.getAttribute("id");

		one = DAO_LOG_FILE.getAdminById(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
	
    
<!-- Header-->
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="INDEX.jsp"><img src="RESOURCES/images/index2.png" alt="Logo" height="45"></a>
                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
 
                    
                </div>
            </div>
            <div class="top-right">
                <div class="header-menu">
                    <div class="user-area dropdown float-right">
                        <a class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           <span><%=one.GET_FIRST_NAME()%> <%=one.GET_LAST_NAME()%></span> 
                        </a>
                    </div>

                </div>
            </div>
        </header>
        <%
        }%>
        <!-- /#header -->