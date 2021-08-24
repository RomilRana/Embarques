package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE;
import COM.CUSTOMER.DAO.DAO_QUOTE_FILE;
import COM.CUSTOMER.DAO.DAO_TRANSPORTER_FILE;

@WebServlet("/CUSTOMER/CONTROLLER_QUOTE_FILE")
@MultipartConfig(fileSizeThreshold = 1024*1024*10,
maxFileSize = 1024*1024*50,
maxRequestSize = 1024*1024*100)
public class CONTROLLER_QUOTE_FIL  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("submit"))
		{
			
				BEAN_QUOTE_FILE second = new BEAN_QUOTE_FILE();
				
				
				HttpSession ses = req.getSession(false);
				int u_id = (Integer) ses.getAttribute("id");
				
				 res.setContentType("text/html;charset=UTF-8");
				 
				int cat_id=Integer.parseInt(req.getParameter("category_id").trim());
				int sub_id=Integer.parseInt(req.getParameter("sub_category_id").trim());
				second.SET_CATEGORY_ID(cat_id);
				second.SET_SUB_CATEGORY_ID(sub_id);
				second.SET_SOURCE_ID(Integer.parseInt(req.getParameter("source_id")));
				second.SET_DESTINATION_ID(Integer.parseInt(req.getParameter("destination_id")));
				second.SET_USER_ID(u_id);
			
			
				second.SET_MESSAGE(req.getParameter("message"));
				second.SET_FROM_DATE(req.getParameter("from"));
				second.SET_TO_DATE(req.getParameter("to"));
				String add_1 = req.getParameter("add_1");
				String add_2 = req.getParameter("add_2");
				String add_3 = add_1+" "+add_2;
				second.SET_ADDRESS(add_3);
				
				DAO_QUOTE_FILE two = new DAO_QUOTE_FILE();
				two.insertdata(second);
				
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

							}
							else
							{
								res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Error");
							}
					}
					 RequestDispatcher rd =  req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=View Quote");
				      rd.include(req,res);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
		}
		else if(act.equalsIgnoreCase("View"))
		{
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_QUOTE_FILE d1 = new DAO_QUOTE_FILE();
			BEAN_QUOTE_FILE one = d1.GET_BY_ID(id);
			if(one==null)
			{
				 res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=No Reply");
			}
			else
			{
			req.setAttribute("quote3",one);
			req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=View Quotes").forward(req,res);
			}
		}
		else if(act.equalsIgnoreCase("Select"))
		{
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_QUOTE_FILE d1 = new DAO_QUOTE_FILE();
			BEAN_QUOTE_FILE one = d1.GET_BY_ID(id);
			req.setAttribute("quote",one);
			req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Select Quote").forward(req,res);
		}
		else if(act.equalsIgnoreCase("CONFIRM"))
		{
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_QUOTE_FILE d1 = new DAO_QUOTE_FILE();
			BEAN_QUOTE_FILE one = d1.GET_BY_ID(id);
			req.setAttribute("quote1",one);
			req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Orders").forward(req,res);
	
		}
		
	}

}
