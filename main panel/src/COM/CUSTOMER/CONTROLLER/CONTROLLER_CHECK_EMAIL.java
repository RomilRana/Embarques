package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.CUSTOMER.BEAN.BEAN_LOG_FILE;
import COM.CUSTOMER.DAO.DAO_LOG_FILE;

public class CONTROLLER_CHECK_EMAIL extends HttpServlet{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		
		String action=req.getParameter("action");
		String email = req.getParameter("cust_email");
		
		int id=0;
		boolean status = DAO_LOG_FILE.isValidEmail(email);
		try
		{
			id=DAO_LOG_FILE.getIdByEmail(email);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		BEAN_LOG_FILE rb = DAO_LOG_FILE.getUserById(id);
		
		if(action.equalsIgnoreCase("submit"))
		{
			if(status)
			{
				HttpSession session = req.getSession();
				session.setAttribute("id", rb.GET_USER_ID());
				
				/* res.sendRedirect("index_1.jsp"); */
						res.setContentType("text/html");
				      PrintWriter pw = res.getWriter();
				      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
				      pw.println("<script>");
				      pw.println("function loa() \r\n" + 
				      		"{\r\n" + 
				      		"	swal(\"Success!\", \"Welcome  "+email+"\", \"success\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"LOGIN_CONTROL_CUSTOMER?page=Home\";\r\n" + 
				      		"	});\r\n" + 
				      		"}");
				      pw.println("</script>");
				      pw.println("<body  onload=\"loa()\"></body");
			}
			else
			{	res.setContentType("text/html");
		      PrintWriter pw = res.getWriter();
		      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
		      pw.println("<script>");
		      pw.println("function loa() \r\n" + 
		      		"{\r\n" + 
		      		"	swal(\"Opps!\", \"You Entered Wrong Details!\", \"error\")\r\n" + 
		      		"	.then((value) => {\r\n" + 
		      		"		window.location.href = \"LOGIN_CONTROL_CUSTOMER?page=Login\";\r\n" + 
		      		"	});\r\n" + 
		      		"}");
		      pw.println("</script>");
		      pw.println("<body  onload=\"loa()\"></body");
			}
		}
		else
		{
			res.sendRedirect("login.jsp?msg=Email or Password Wrong...!");
		}
		
	}

}
