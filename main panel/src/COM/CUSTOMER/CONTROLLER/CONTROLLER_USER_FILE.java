package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import COM.CUSTOMER.BEAN.BEAN_USER_FILE;
import COM.CUSTOMER.DAO.DAO_LOG_FILE;
import COM.CUSTOMER.DAO.DAO_USER_FILE;

@WebServlet("/CUSTOMER/USER_ONE")

public class CONTROLLER_USER_FILE extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		String email = req.getParameter("cust_email");
		
		boolean status = DAO_LOG_FILE.isValidEmail(email);
		
		
		if(act.equalsIgnoreCase("Sign Up"))
		{
			if(!status)
			{
					if(REGISTER_MANAGER.GENERATE_OTP(email))
					{
						BEAN_USER_FILE second = new BEAN_USER_FILE();
						
						second.SET_USER_NAME(req.getParameter("cust_email"));
						second.SET_USER_PASSWORD(req.getParameter("cust_password"));
						second.SET_FIRST_NAME(req.getParameter("first_name"));
						second.SET_LAST_NAME(req.getParameter("last_name"));
						second.SET_CONTACT(req.getParameter("contact"));
						req.setAttribute("user_register",second);
						req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Register Otp").forward(req,res);
					}
					else
					{
						res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Error");
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
			      		"		window.location.href = \"HOME_CONTROL_CUSTOMER?page=Register\";\r\n" + 
			      		"	});\r\n" + 
			      		"}");
			      pw.println("</script>");
			      pw.println("<body  onload=\"loa()\"></body");
			}
		}
		
	}

}
