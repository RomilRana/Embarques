package COM.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import COM.BEAN.BEAN_PROFILE_FILE;
import COM.BEAN.BEAN_USER_FILE;
import COM.CONNECT.CONNECT_FILE;

public class DAO_PROFILE {
	
	public BEAN_PROFILE_FILE GET_BY_ID(String id)
	{
		BEAN_PROFILE_FILE one = new BEAN_PROFILE_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from admin_log where admin_email=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_NAME(rs.getString("admin_email"));
				one.SET_FIRST_NAME(rs.getString("first_name"));
				one.SET_LAST_NAME(rs.getString("last_name"));
				one.SET_CONTACT(rs.getInt("contact"));
				one.SET_USER_ID(rs.getInt("admin_id"));
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
		return one;
	}
	public BEAN_PROFILE_FILE GET_BY_UID(int id)
	{
		BEAN_PROFILE_FILE one = new BEAN_PROFILE_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from admin_log where admin_id=?";
			
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_ID(rs.getInt("admin_id"));
				one.SET_USER_NAME(rs.getString("admin_email"));
				one.SET_FIRST_NAME(rs.getString("first_name"));
				one.SET_LAST_NAME(rs.getString("last_name"));
				one.SET_CONTACT(rs.getInt("contact"));
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
		return one;
	}
	public void UPDATE_FILE(BEAN_PROFILE_FILE one)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "update admin_log set first_name=? where admin_id=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, one.GET_FIRST_NAME());
			ps.setInt(2, one.GET_USER_ID());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}
