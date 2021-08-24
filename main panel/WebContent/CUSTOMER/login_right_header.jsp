<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.List" %>
    <%@page import="COM.CUSTOMER.BEAN.BEAN_LOG_FILE" %>
    <%@page import="COM.CUSTOMER.DAO.DAO_LOG_FILE" %>

<div class="top-line">
<%
BEAN_LOG_FILE two=null;
if(null == session.getAttribute("id"))
{
	request.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER").forward(request, response);
}
else
{
		Cookie[] hi = request.getCookies();
		String uname="";
		
		if(hi!=null)
		{
			for(Cookie hello : hi)
			{
				if(hello.getName().equals("email"))
				{
					uname=hello.getValue();
				}
			}
		}
		int id;
		try
		{
			id=DAO_LOG_FILE.getIdByEmail(uname);
		
			two = DAO_LOG_FILE.getUserById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
%>

						<div class="container">
							<div class="row">
								<div class="col-sm-12">
									<ul class="info-list">
										<li>
											<p><i class="fa fa-phone"></i>Call us <span>079-22166048 </span></p>
										</li>
										<li>
											<p><i class="fa fa-clock-o"></i>Working time <span>Mon-Sat,10am-6pm </span></p>
										</li>
										<li>
											<p><i class="fa fa-user"></i>Hello<span><%=two.GET_FIRST_NAME()%> <%=two.GET_LAST_NAME()%></span></p>
										</li>
									</ul>
								</div>	
							</div>
						</div>
					</div>
					<%
					}
					%>