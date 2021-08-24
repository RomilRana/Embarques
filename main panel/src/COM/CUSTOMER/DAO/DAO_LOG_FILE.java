package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import COM.CUSTOMER.BEAN.BEAN_LOG_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_LOG_FILE {
	public static int getIdByEmail(String email) throws SQLException
	{
		Connection cn = CONNECT_FILE.sqlConnection();
		String query = "select * from cust_table where cust_email='"+email+"' and is_active=1";
		PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			return rs.getInt("cust_id");
		}
		return 0;
		
	}
	public static BEAN_LOG_FILE getUserById(int id)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table where cust_id=? and is_active=1";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				BEAN_LOG_FILE rb = new BEAN_LOG_FILE();
				
				rb.SET_USER_ID(rs.getInt("cust_id"));
				rb.SET_FIRST_NAME(rs.getString("first_name"));
				rb.SET_LAST_NAME(rs.getString("last_name"));
				rb.SET_USER_NAME(rs.getString("cust_email"));
				rb.SET_USER_PASSWORD(rs.getString("cust_password"));
				rb.SET_CONTACT(rs.getString("contact"));
				
				return rb;
				
			}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public static boolean isValidUser(String email,String pass)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table where cust_email='"+email+"' AND cust_password='"+pass+"'";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	
	public static boolean isValidEmail(String email)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table where cust_email='"+email+"'";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
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
	
	public static BEAN_LOG_FILE getTransporterById(String email)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from trans_table where trans_email=?";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				BEAN_LOG_FILE rb = new BEAN_LOG_FILE();
				
				rb.SET_USER_ID(rs.getInt("trans_id"));
				rb.SET_FIRST_NAME(rs.getString("first_name"));
				rb.SET_LAST_NAME(rs.getString("last_name"));
				rb.SET_USER_NAME(rs.getString("trans_email"));
				rb.SET_USER_PASSWORD(rs.getString("trans_password"));
				rb.SET_CONTACT(rs.getString("contact"));
				
				return rb;
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
