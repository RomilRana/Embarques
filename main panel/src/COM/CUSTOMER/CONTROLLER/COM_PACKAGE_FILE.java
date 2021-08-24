package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.CUSTOMER.DAO.*;
import COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;
import COM.CUSTOMER.BEAN.BEAN_PACKAGE_FILE;


@WebServlet("/CUSTOMER/PACKAGE_ONE")
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
		
		if(act.equalsIgnoreCase("select"))
		{
			
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_PACKAGE_FILE d1 = new DAO_PACKAGE_FILE();
			BEAN_PACKAGE_FILE one = d1.GET_BY_ID(id);
			req.setAttribute("pack",one);
			/* req.getRequestDispatcher("send_package_message.jsp").forward(req,res); */
			req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Send Package Message").forward(req,res);
		}
		else if(act.equalsIgnoreCase("send"))
		{
			String des = req.getParameter("description");
			
			
			
			BEAN_PACKAGE_FILE second = new BEAN_PACKAGE_FILE();
			
			HttpSession ses = req.getSession(false);
			int u_id = (Integer) ses.getAttribute("id");
			
			int id = Integer.parseInt(req.getParameter("id11"));
			try {
				Connection cn1 = CONNECT_FILE.sqlConnection();
				String query1 = "select * from package INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id where package_id=? and active_package=1";

				PreparedStatement ps1 = cn1.prepareStatement(query1);
				ps1.setInt(1, id);
				ResultSet rs = ps1.executeQuery();
				if (rs.next()) {
			
			
			second.SET_USER_ID(u_id);
			second.SET_PACKAGE_ID(rs.getInt("package_id"));
			second.SET_TRANSPORTER_ID(rs.getInt("trans_id"));
			second.SET_TRANSPORTER_NAME(rs.getString("trans_email"));
			second.SET_COMPANY_NAME(rs.getString("company_name"));
			second.SET_FROM_NAME(rs.getString("source_name"));
			second.SET_TO_NAME(rs.getString("destination_name"));
			second.SET_FROM_ID(rs.getInt("source_id"));
			second.SET_TO_ID(rs.getInt("destination_id"));
			second.SET_PACKAGE_PRICE(rs.getInt("package_price"));
			second.SET_PACKAGE_NAME(rs.getString("package_title"));
			second.SET_PACKAGE_DESCRIPTION(rs.getString("package_description"));
			second.SET_IMAGE_NAME(rs.getString("image"));
			String add_1 = req.getParameter("add_1");
			String add_2 = req.getParameter("add_2");
			String add_3 = add_1+" "+add_2;
			System.out.println("address is:="+add_3);
			second.SET_ADDRESS(add_3);
			second.SET_FIRST_NAME(req.getParameter("first_name"));
			second.SET_LAST_NAME(req.getParameter("last_name"));
			second.SET_CONTACT(req.getParameter("contact"));
				}
			else
			{
				second=null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			BEAN_QUOTE_FILE one = new BEAN_QUOTE_FILE();
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "select * from package where package_id=?";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1,second.GET_PACKAGE_ID());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					one.SET_TRANS_ID(rs.getInt("trans_id"));
					one.SET_IMAGE_NAME(rs.getString("image"));
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
			second.SET_TRANSPORTER_ID(one.GET_TRANS_ID());
			second.SET_IMAGE_NAME(one.GET_IMAGE_NAME());
			second.SET_DESCRIPTION(des);;
			DAO_PACKAGE_FILE two = new DAO_PACKAGE_FILE();
			two.insertdata(second);
		
			/* req.getRequestDispatcher("view_packages.jsp").forward(req,res); */
			req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=View Packages").forward(req,res);
		}
	}
	

}
