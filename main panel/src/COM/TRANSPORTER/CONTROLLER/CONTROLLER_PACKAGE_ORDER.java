package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.TRANSPORTER.DAO.DAO_PACKAGE_ORDER_FILE;
import COM.CUSTOMER.BEAN.BEAN_ORDER_FILE;
import COM.TRANSPORTER.BEAN.BEAN_PACKAGE_ORDER_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;

@WebServlet("/TRANSPORTER/PACKAGE_ORDER_ONE")
public class CONTROLLER_PACKAGE_ORDER extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("Confirm"))
		{
			
			int id = Integer.parseInt(req.getParameter("id11"));
			try
			{
				Connection con =CONNECT_FILE.sqlConnection();
				
				String query = "Update package_booking set active_pack=0 where package_id='"+id+"'";
				PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
		
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			BEAN_PACKAGE_ORDER_FILE one = new BEAN_PACKAGE_ORDER_FILE();
		
			
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query="SELECT * FROM package_booking INNER JOIN package ON package_booking.package_id = package.package_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id  WHERE package.package_id='"+id+"'";
				PreparedStatement ps = cn.prepareStatement(query);
			
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					one.SET_PACKAGE_BOOKING_ID(rs.getInt("package_booking_id"));
					one.SET_PACKAGE_ID(rs.getInt("package_id"));
				
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
			DAO_PACKAGE_ORDER_FILE two = new DAO_PACKAGE_ORDER_FILE();
			two.insertdata(one);
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=View Package Order").forward(req,res);
		}
		else if(act.equalsIgnoreCase("Decline"))
		{
			int id = Integer.parseInt(req.getParameter("id11"));
			try
			{
				Connection con =CONNECT_FILE.sqlConnection();
				
				String query = "Update package_booking set active_pack=0 where package_id='"+id+"'";
				PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
		
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(act.equalsIgnoreCase("Delivered"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			int id1 = Integer.parseInt(req.getParameter("id1"));
			BEAN_ORDER_FILE one = new BEAN_ORDER_FILE();
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "update package_order set delivered=1 where package_booking_id='"+id+"' and trans_id='"+id1+"'";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(act.equalsIgnoreCase("Dispatch"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			int id1 = Integer.parseInt(req.getParameter("id1"));
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "update package_order set dispatch=1 where package_booking_id='"+id+"' and trans_id='"+id1+"'";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Home").forward(req,res);
		}
	}

}
