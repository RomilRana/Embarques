package COM.TRANSPORTER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import COM.TRANSPORTER.BEAN.BEAN_PACKAGE_ORDER_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;

public class DAO_PACKAGE_ORDER_FILE {

	public void insertdata(BEAN_PACKAGE_ORDER_FILE b2)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query="insert into package_order(package_booking_id,package_id,date_of_order) values(?,?,'"+dtf.format(now)+"')";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(query);
			ps.setInt(1,b2.GET_PACKAGE_BOOKING_ID());
			ps.setInt(2,b2.GET_PACKAGE_ID());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<BEAN_PACKAGE_ORDER_FILE> getAllInfo(int id) throws SQLException
	{
		List<BEAN_PACKAGE_ORDER_FILE> list = new ArrayList<BEAN_PACKAGE_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "SELECT * FROM package_order INNER JOIN package ON package_order.package_id = package.package_id INNER JOIN package_booking ON package_order.package_booking_id = package_booking.package_booking_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id  WHERE trans_table.trans_id='"+id+"' and cancel=0";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_PACKAGE_ORDER_FILE eb = new BEAN_PACKAGE_ORDER_FILE();
				eb.SET_PACKAGE_BOOKING_ID(re.getInt("package_booking_id"));
				eb.SET_PACKAGE_ID(re.getInt("package_id"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_TRANSPORTER_ID(re.getInt("trans_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_PACKAGE_PRICE(re.getInt("package_price"));
				eb.SET_PACKAGE_NAME(re.getString("package_title"));
				eb.SET_FROM_NAME(re.getString("source_name"));
				eb.SET_TO_NAME(re.getString("destination_name"));
				eb.SET_PACKAGE_DESCRIPTION(re.getString("package_description"));
				eb.SET_IMAGE_NAME(re.getString("image"));
				list.add(eb);
			}
			re.close();
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<BEAN_PACKAGE_ORDER_FILE> getAllInfo1(int id) throws SQLException
	{
		List<BEAN_PACKAGE_ORDER_FILE> list = new ArrayList<BEAN_PACKAGE_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "SELECT * FROM package_order INNER JOIN package ON package_order.package_id = package.package_id INNER JOIN package_booking ON package_order.package_booking_id = package_booking.package_booking_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id WHERE cust_table.cust_id='"+id+"' and cancel=0";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_PACKAGE_ORDER_FILE eb = new BEAN_PACKAGE_ORDER_FILE();
				eb.SET_PACKAGE_BOOKING_ID(re.getInt("package_booking_id"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_PACKAGE_PRICE(re.getInt("package_price"));
				eb.SET_PACKAGE_NAME(re.getString("package_title"));
				eb.SET_FROM_NAME(re.getString("source_name"));
				eb.SET_TO_NAME(re.getString("destination_name"));
				eb.SET_FIRST_NAME(re.getString("first_name"));
				eb.SET_LAST_NAME(re.getString("last_name"));
				eb.SET_ADDRESS(re.getString("address"));
				eb.SET_CONTACT(re.getString("contact"));
				eb.SET_PACKAGE_DESCRIPTION(re.getString("package_description"));
				eb.SET_IMAGE_NAME(re.getString("image"));
				list.add(eb);
			}
			re.close();
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<BEAN_PACKAGE_ORDER_FILE> getAllInfo2(int id) throws SQLException
	{
		List<BEAN_PACKAGE_ORDER_FILE> list = new ArrayList<BEAN_PACKAGE_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "SELECT * FROM package_order INNER JOIN package ON package_order.package_id = package.package_id INNER JOIN package_booking ON package_order.package_booking_id = package_booking.package_booking_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id WHERE trans_table.trans_id='"+id+"' and cancel=0";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_PACKAGE_ORDER_FILE eb = new BEAN_PACKAGE_ORDER_FILE();
				eb.SET_PACKAGE_BOOKING_ID(re.getInt("package_booking_id"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_PACKAGE_PRICE(re.getInt("package_price"));
				eb.SET_PACKAGE_NAME(re.getString("package_title"));
				eb.SET_FROM_NAME(re.getString("source_name"));
				eb.SET_TO_NAME(re.getString("destination_name"));
				eb.SET_FIRST_NAME(re.getString("first_name"));
				eb.SET_LAST_NAME(re.getString("last_name"));
				eb.SET_ADDRESS(re.getString("address"));
				eb.SET_CONTACT(re.getString("contact"));
				eb.SET_PACKAGE_DESCRIPTION(re.getString("package_description"));
				eb.SET_IMAGE_NAME(re.getString("image"));
				list.add(eb);
			}
			re.close();
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static boolean isValidUser(int cust_id,int order_id)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where cust_id='"+cust_id+"' AND package_id='"+order_id+"'";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
