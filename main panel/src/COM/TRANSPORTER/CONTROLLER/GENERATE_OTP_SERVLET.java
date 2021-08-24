package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.TRANSPORTER.BEAN.BEAN_LOG_FILE;
import COM.TRANSPORTER.DAO.DAO_LOG_FILE;


@WebServlet("/TRANSPORTER/GENERATE_OTP_SERVLET")
public class GENERATE_OTP_SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html;charset=UTF=8");
		try(PrintWriter out = res.getWriter())
		{
			String action=req.getParameter("action");
			String email = req.getParameter("email");
			
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
					session.setAttribute("id", rb.GET_TRANSPORTER_ID());
					
					if(FORGET_PASSWORD_MANAGER.GENERATE_OTP(email))
					{
						res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Password Otp");
					}
					else
					{
						res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Error");
					}
				}
				else
				{	res.setContentType("text/html");
			      PrintWriter pw = res.getWriter();
			      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
			      pw.println("<script>");
			      pw.println("function loa() \r\n" + 
			      		"{\r\n" + 
			      		"	swal(\"Opps!\", \"You Entered Wrong Email!\", \"error\")\r\n" + 
			      		"	.then((value) => {\r\n" + 
			      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Forgot\";\r\n" + 
			      		"	});\r\n" + 
			      		"}");
			      pw.println("</script>");
			      pw.println("<body  onload=\"loa()\"></body");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
  
}
