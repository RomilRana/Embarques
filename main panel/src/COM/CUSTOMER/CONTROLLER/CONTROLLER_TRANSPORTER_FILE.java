package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import COM.CUSTOMER.BEAN.BEAN_USER_FILE;
import COM.CUSTOMER.DAO.DAO_TRANSPORTER_FILE;
@WebServlet("/CUSTOMER/TRANS_ONE")
public class CONTROLLER_TRANSPORTER_FILE extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("submit"))
		{
					BEAN_USER_FILE second = new BEAN_USER_FILE();
			
					second.SET_USER_NAME(req.getParameter("trans_email"));
					second.SET_USER_PASSWORD(req.getParameter("trans_password"));
					second.SET_FIRST_NAME(req.getParameter("first_name"));
					second.SET_LAST_NAME(req.getParameter("last_name"));
					second.SET_CONTACT(req.getParameter("contact"));
					
					DAO_TRANSPORTER_FILE one = new DAO_TRANSPORTER_FILE();
					one.insertdata(second);
					
					req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Home").forward(req,res);
			
		}
		
		
	}

}
