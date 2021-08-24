package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import COM.TRANSPORTER.DAO.DAO_PACKAGE_FILE;
import COM.TRANSPORTER.DAO.DAO_QUOTE_FILE;
import COM.CUSTOMER.BEAN.BEAN_ORDER_FILE;
import COM.TRANSPORTER.BEAN.BEAN_PACKAGE_FILE;
import COM.TRANSPORTER.BEAN.BEAN_PACKAGE_ORDER_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;


@WebServlet("/TRANSPORTER/PACKAGE")
@MultipartConfig(fileSizeThreshold = 1024*1024*10,
maxFileSize = 1024*1024*50,
maxRequestSize = 1024*1024*100)
public class COM_PACKAGE_FILE extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("submit"))
		{
			BEAN_PACKAGE_FILE second = new BEAN_PACKAGE_FILE();
			
			HttpSession ses = req.getSession(false);
			int u_id = (Integer) ses.getAttribute("id");
			
			
			second.SET_TRANSPORTER_ID(u_id);
			
			second.SET_PACKAGE_PRICE(Integer.parseInt(req.getParameter("package_price")));
			second.SET_PACKAGE_NAME(req.getParameter("package_name"));
			second.SET_FROM_ID(Integer.parseInt(req.getParameter("from_name")));
			second.SET_TO_ID(Integer.parseInt(req.getParameter("to_name")));
			second.SET_PACKAGE_DESCRIPTION(req.getParameter("package_description"));
			
			Part p1 = req.getPart("one");
			String path = req.getServletContext().getRealPath("//IMAGES") + "\\QUOTE\\"+p1.getSubmittedFileName();
			
			p1.write(path);
			
			second.SET_IMAGE_NAME(p1.getSubmittedFileName());
			
			DAO_PACKAGE_FILE two = new DAO_PACKAGE_FILE();
			two.insertdata(second);
			
			/* req.getRequestDispatcher("view_package.jsp").forward(req,res); */
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=View Package").forward(req,res);
			
		}
		
		else if(act.equalsIgnoreCase("delete"))
		{
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_PACKAGE_FILE d1 = new DAO_PACKAGE_FILE();
		
			d1.DELETE_PACKAGE(id);
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=View Package").forward(req,res);
			
		}
		else if(act.equalsIgnoreCase("edit"))
		{
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_PACKAGE_FILE d1 = new DAO_PACKAGE_FILE();
			BEAN_PACKAGE_FILE one = d1.GET_BY_ID(id);
			req.setAttribute("package",one);
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Update Package").forward(req,res);
		}
		else if(act.equalsIgnoreCase("save"))
		{
			BEAN_PACKAGE_FILE one = new BEAN_PACKAGE_FILE();
			
			one.SET_PACKAGE_ID(Integer.parseInt(req.getParameter("id11")));
			Connection cn = CONNECT_FILE.sqlConnection();
			int id=Integer.parseInt(req.getParameter("id11"));
			String query = "select * from package INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id where package_id='"+id+"'";
			String im = null;
			try
			{
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				im=rs.getString("image");
			}
			else
			{
				one=null;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			one.SET_PACKAGE_NAME(req.getParameter("package_name"));
			one.SET_PACKAGE_DESCRIPTION(req.getParameter("package_description"));
			one.SET_FROM_ID(Integer.parseInt(req.getParameter("from_name")));
			one.SET_TO_ID(Integer.parseInt(req.getParameter("to_name")));
			one.SET_PACKAGE_PRICE(Integer.parseInt(req.getParameter("package_price")));
			
			Part p1 = req.getPart("one");
			
			String i_name=p1.getSubmittedFileName();
			System.out.println(i_name);
			
			if(i_name.isEmpty())
			{
				one.SET_IMAGE_NAME(im);
			}
			else
			{

				String path = req.getServletContext().getRealPath("//IMAGES") + "\\QUOTE\\"+p1.getSubmittedFileName();
				p1.write(path);
				one.SET_IMAGE_NAME(p1.getSubmittedFileName());
			}
			DAO_PACKAGE_FILE d1 = new DAO_PACKAGE_FILE();
			d1.UPDATE_PACKAGE(one);
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=View Package").forward(req,res);
		}	
		else if(act.equalsIgnoreCase("cancel"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			int id1 = Integer.parseInt(req.getParameter("id1"));
			
			System.out.println(id);
			System.out.println(id1);
			BEAN_PACKAGE_ORDER_FILE eb = new BEAN_PACKAGE_ORDER_FILE();
			String reason= req.getParameter("reason");
			System.out.println(reason);
			try
			{
				Connection con =CONNECT_FILE.sqlConnection();
				String query = "SELECT * FROM package_order INNER JOIN package ON package_order.package_id = package.package_id INNER JOIN package_booking ON package_order.package_booking_id = package_booking.package_booking_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id  WHERE package.trans_id='"+id1+"' and package_booking.package_booking_id='"+id+"'";
				PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
				ResultSet re = ps.executeQuery();
				
				if(re.next())
				{
					eb.SET_PACKAGE_BOOKING_ID(id);
					eb.SET_PACKAGE_ID(re.getInt("package_id"));
					eb.SET_PACKAGE_ORDER_ID(re.getInt("order_id"));
					eb.SET_USER_ID(re.getInt("cust_id"));
					eb.SET_USER_NAME(re.getString("cust_email"));
					eb.SET_PACKAGE_PRICE(re.getInt("package_price"));
					eb.SET_PACKAGE_NAME(re.getString("package_title"));
					eb.SET_FROM_NAME(re.getString("source_name"));
					eb.SET_TO_NAME(re.getString("destination_name"));
					eb.SET_PACKAGE_DESCRIPTION(re.getString("package_description"));
					eb.SET_IMAGE_NAME(re.getString("image"));
					eb.SET_REASON(reason);
				}
				else
				{
					eb=null;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			DAO_PACKAGE_FILE two = new DAO_PACKAGE_FILE();
			two.insertcanceldata(eb);
			
			RequestDispatcher rd =  req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Home");
			rd.include(req,res);
		}
		
	}
	

}
