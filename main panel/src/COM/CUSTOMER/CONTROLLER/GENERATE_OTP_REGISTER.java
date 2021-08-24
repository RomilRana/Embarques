package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CUSTOMER/GENERATE_OTP_REGISTER")
public class GENERATE_OTP_REGISTER extends HttpServlet{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html;charset=UTF=8");
		try(PrintWriter out = res.getWriter())
		{
			String action=req.getParameter("action");
			

			
			if(action.equalsIgnoreCase("submit"))
			{
				String email = req.getParameter("cust_email");
					if(REGISTER_MANAGER.GENERATE_OTP(email))
					{
						res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Register Otp");
					}
					else
					{
						res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Error");
					}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
