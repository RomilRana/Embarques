package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.CUSTOMER.BEAN.BEAN_FEEDBACK_FILE;
import COM.CUSTOMER.DAO.DAO_FEEDBACK_FILE;
@WebServlet("/TRANSPORTER/feedback_transporter")
public class CONTROLLER_FEEDBACK_FILE extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("submit"))
		{
			BEAN_FEEDBACK_FILE one = new BEAN_FEEDBACK_FILE();
			
			
			String message = req.getParameter("message");
			one.SET_MESSAGE(message);
			one.SET_USER_NAME(req.getParameter("trans_mail"));
			one.SET_GIVEN_BY("Transporter");
			
			DAO_FEEDBACK_FILE two = new DAO_FEEDBACK_FILE();
			two.insertdata(one);
			res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Home");
		}	
		
	}

}
