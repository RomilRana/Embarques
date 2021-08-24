package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.TRANSPORTER.BEAN.BEAN_LOG_FILE;
import COM.TRANSPORTER.DAO.DAO_LOG_FILE;

@WebServlet("/TRANSPORTER/LOG_TWO")
public class CONTROLLER_LOG_USER_FILE extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		
		String action=req.getParameter("action");
		String email = req.getParameter("trans_email");
		String pass = req.getParameter("trans_password");
		
		boolean remember = req.getParameter("remember")!=null;
		if(remember==true)
		{
			Cookie jguser = new Cookie("trans_email",email.toString());
			Cookie jgpass =  new Cookie("trans_password",pass.toString());
			res.addCookie(jguser);
			res.addCookie(jgpass);
		}
		
		Cookie trans_user = new Cookie("email",email.toString());
		res.addCookie(trans_user);
		
		String name=req.getParameter("name");
	    
		
	
		int id=0;
		boolean status = DAO_LOG_FILE.isValidUser(email, pass);
		try
		{
			id=DAO_LOG_FILE.getIdByEmail(email);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		BEAN_LOG_FILE rb = DAO_LOG_FILE.getUserById(id);
		
		if(action.equalsIgnoreCase("Sign In"))
		{
			if(status)
			{
				
					HttpSession session = req.getSession();
					session.setAttribute("id", rb.GET_TRANSPORTER_ID());
					
					
					  res.setContentType("text/html"); PrintWriter pw = res.getWriter();
					  pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
					  pw.println("<script>");
					  
					  pw.println("function loa() \r\n" + "{\r\n" +
					  "	swal(\"Success!\", \"Welcome  "+email+"\", \"success\")\r\n" +
					  "	.then((value) => {\r\n" +
					  
					 "		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?"+name+"\";\r\n" + "	});\r\n" + "}");
					  pw.println("</script>"); pw.println("<body  onload=\"loa()\"></body");
				
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
	      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Login\";\r\n" + 
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
