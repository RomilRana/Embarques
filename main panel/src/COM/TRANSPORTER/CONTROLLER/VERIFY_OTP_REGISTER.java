package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.TRANSPORTER.CONTROLLER.REGISTER_MANAGER;
import COM.TRANSPORTER.BEAN.BEAN_USER_FILE;
import COM.TRANSPORTER.DAO.DAO_TRANSPORTER_FILE;

@WebServlet("/TRANSPORTER/VERIFY_OTP")

public class VERIFY_OTP_REGISTER extends HttpServlet{
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html);charset=UTF=8");
		try(PrintWriter out = res.getWriter())
		{
			String otp = req.getParameter("otp");
			
			boolean stat =  REGISTER_MANAGER .VERIFY_OTP(otp);
			if(stat)
			{	
				BEAN_USER_FILE second = new BEAN_USER_FILE();
				
				second.SET_USER_NAME(req.getParameter("trans_email"));
				second.SET_USER_PASSWORD(req.getParameter("trans_password"));
				second.SET_FIRST_NAME(req.getParameter("first_name"));
				second.SET_LAST_NAME(req.getParameter("last_name"));
				second.SET_COMPANY_NAME(req.getParameter("company_name"));
				second.SET_CONTACT(req.getParameter("contact"));
				
				DAO_TRANSPORTER_FILE one = new DAO_TRANSPORTER_FILE();
				one.insertdata(second);
				
				String email = req.getParameter("trans_email");
				String fname = req.getParameter("first_name");
				String lname = req.getParameter("last_name");
				if(REGISTER_MANAGER.GENERATE_Register_Mail(email,fname,lname))
				{
					req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Login").forward(req,res); 
				}
				else
				{
					res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Error");
				} 
			}					
			else
			{
				res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Error");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
