package COM.CUSTOMER.CONTROLLER;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.CUSTOMER.DAO.DAO_TRANSPORTER_FILE;


@WebServlet("/CUSTOMER/GENERATE_NOTIFICATION")
public class GENERATE_NOTIFICATION extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html;charset=UTF=8");
		try(PrintWriter out = res.getWriter())
		{
			
			DAO_TRANSPORTER_FILE ed = new DAO_TRANSPORTER_FILE();
			List<COM.CUSTOMER.BEAN.BEAN_USER_FILE> list =ed.getTransporter();
			
			for(COM.CUSTOMER.BEAN.BEAN_USER_FILE info: list)
			{
				String email = info.GET_USER_NAME();
				String fname = info.GET_FIRST_NAME();
				String lname = info.GET_LAST_NAME();
					
					if(CONTROLLER_NOTIFICATION_FILE.GENERATE_Mail(email,fname,lname))
					{
						res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Home");
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
