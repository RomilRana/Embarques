package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.CUSTOMER.BEAN.BEAN_USER_FILE;
import COM.CUSTOMER.DAO.DAO_USER_FILE;

@WebServlet("/CUSTOMER/VERIFY_OTP")

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
				
				second.SET_USER_NAME(req.getParameter("cust_email"));
				second.SET_USER_PASSWORD(req.getParameter("cust_password"));
				second.SET_FIRST_NAME(req.getParameter("first_name"));
				second.SET_LAST_NAME(req.getParameter("last_name"));
				second.SET_CONTACT(req.getParameter("contact"));
				
				DAO_USER_FILE one = new DAO_USER_FILE();
				one.insertdata(second);
				
				String email = req.getParameter("cust_email");
				String fname = req.getParameter("first_name");
				String lname = req.getParameter("last_name");
				if(REGISTER_MANAGER.GENERATE_Register_Mail(email,fname,lname))
				{
					req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Login").forward(req,res); 
				}
				else
				{
					res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Error");
				}
				
			}					
			else
			{
				res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Error");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
