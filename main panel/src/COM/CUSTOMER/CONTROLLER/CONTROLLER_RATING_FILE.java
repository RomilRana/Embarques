package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.CUSTOMER.BEAN.BEAN_ORDER_FILE;
import COM.CUSTOMER.BEAN.BEAN_RATING_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;
import COM.CUSTOMER.DAO.DAO_ORDER_FILE;
import COM.CUSTOMER.DAO.DAO_RATING_FILE;
@WebServlet("/CUSTOMER/rate")
public class CONTROLLER_RATING_FILE  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String action = req.getParameter("action");
		if(action.equalsIgnoreCase("submit"))
		{
			String star=req.getParameter("rate");
			int id = Integer.parseInt(req.getParameter("trans_quote_id"));
			BEAN_RATING_FILE one = new BEAN_RATING_FILE();
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "select * from order_tab INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id  INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id   WHERE send_reply.trans_quote_id=? and delivered=1;";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					one.SET_TRANS_ID(rs.getInt("trans_id"));
					one.SET_QUOTE_ID(rs.getInt("order_id"));
					one.SET_USER_ID(rs.getInt("cust_id"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			one.SET_RATING(star);
			DAO_RATING_FILE two = new DAO_RATING_FILE();
			two.insertdata(one);
			res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Home");
			
		}
		else if(action.equalsIgnoreCase("give"))
		{
			String star=req.getParameter("rate");
			int id = Integer.parseInt(req.getParameter("package_id"));
			BEAN_RATING_FILE one = new BEAN_RATING_FILE();
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "SELECT * FROM package_order INNER JOIN source_table ON package_order.source_id = source_table.source_id INNER JOIN destination_table ON package_order.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_order.cust_id = cust_table.cust_id INNER JOIN trans_table ON package_order.trans_id = trans_table.trans_id INNER JOIN package_booking ON package_order.package_booking_id = package_booking.package_booking_id INNER JOIN package ON package_order.package_id = package.package_id WHERE package.package_id=? and delivered=1;";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					one.SET_TRANS_ID(rs.getInt("trans_id"));
					one.SET_PACKAGE_ORDER_ID(rs.getInt("package_order_id"));
					one.SET_USER_ID(rs.getInt("cust_id"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			one.SET_RATING(star);
			DAO_RATING_FILE two = new DAO_RATING_FILE();
			two.insertPackagedata(one);
			res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Home");
			
		}
	}

}
