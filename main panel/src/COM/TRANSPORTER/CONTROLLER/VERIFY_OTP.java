package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TRANSPORTER/VERIFY_OTP_SERVLET")
public class VERIFY_OTP extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html);charset=UTF=8");
		try(PrintWriter out = res.getWriter())
		{
			String email=req.getParameter("email");
			String otp = req.getParameter("otp");
			
			boolean stat =  FORGET_PASSWORD_MANAGER.VERIFY_OTP(email,otp);
			if(stat)
			{
				res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Reset Password");
			}					
			else
			{
				res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Error");
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
