package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.TRANSPORTER.CONTROLLER.REGISTER_MANAGER;
import COM.CUSTOMER.DAO.DAO_LOG_FILE;
import COM.TRANSPORTER.BEAN.BEAN_USER_FILE;

import COM.TRANSPORTER.DAO.DAO_TRANSPORTER_FILE;

@WebServlet("/TRANSPORTER/TRANS_ONE")
public class CONTROLLER_TRANSPORTER_FILE extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		
		String email = req.getParameter("trans_email");
		
		boolean status = DAO_LOG_FILE.isValidEmail(email);
		if(act.equalsIgnoreCase("Sign Up"))
		{
			if(!status)
			{
				if(REGISTER_MANAGER.GENERATE_OTP(email))
				{
						BEAN_USER_FILE second = new BEAN_USER_FILE();
				
						second.SET_USER_NAME(req.getParameter("trans_email"));
						second.SET_USER_PASSWORD(req.getParameter("trans_password"));
						second.SET_FIRST_NAME(req.getParameter("first_name"));
						second.SET_LAST_NAME(req.getParameter("last_name"));
						second.SET_CONTACT(req.getParameter("contact"));
						second.SET_COMPANY_NAME(req.getParameter("company_name"));
						
						
						req.setAttribute("user_register",second);
						req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Register Otp").forward(req,res);
				}
				else
				{
					res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Error");
				}
			}
			else
			{
					res.setContentType("text/html");
			      PrintWriter pw = res.getWriter();
			      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
			      pw.println("<script>");
			      pw.println("function loa() \r\n" + 
			      		"{\r\n" + 
			      		"	swal(\"Opps!\", \"This Email is already Register!\", \"error\")\r\n" + 
			      		"	.then((value) => {\r\n" + 
			      		"		window.location.href = \"HOME_CONTROL_TRANSPORTER?page=Register\";\r\n" + 
			      		"	});\r\n" + 
			      		"}");
			      pw.println("</script>");
			      pw.println("<body  onload=\"loa()\"></body");
			}
		}
		
		
		
	}

}
