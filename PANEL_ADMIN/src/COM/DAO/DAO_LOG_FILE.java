package COM.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import COM.BEAN.BEAN_LOG_FILE;
import COM.CONNECT.CONNECT_FILE;

public class DAO_LOG_FILE {
	
	
	public static int getIdByEmail(String email) throws SQLException
	{
		Connection cn = CONNECT_FILE.sqlConnection();
		String query = "select * from admin_log where admin_email='"+email+"'";
		PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			return rs.getInt("admin_id");
		}
		return 0;
		
	}
	public static BEAN_LOG_FILE getAdminById(int id)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from admin_log where admin_id=?";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				BEAN_LOG_FILE rb = new BEAN_LOG_FILE();
				
				rb.SET_ADMIN_ID(rs.getInt("admin_id"));
				rb.SET_FIRST_NAME(rs.getString("first_name"));
				rb.SET_LAST_NAME(rs.getString("last_name"));
				rb.SET_ADMIN_NAME(rs.getString("admin_email"));
				rb.SET_ADMIN_PASSWORD(rs.getString("admin_password"));
				rb.SET_CONTACT(rs.getInt("contact"));
				
				return rb;
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static boolean isValidAdmin(String email,String pass)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from admin_log where admin_email='"+email+"' AND admin_password='"+pass+"'";
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
}
