package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CUSTOMER/CHANGE_PASSWORD_SERVLET")
public class CHANGE_FORGET_PASSWORD extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		try(PrintWriter out = res.getWriter())
		{
		
		boolean stat = REGISTRATION_MANAGER.updateUserPass(pass,email);
		if(stat)
		{
			res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Login");
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
