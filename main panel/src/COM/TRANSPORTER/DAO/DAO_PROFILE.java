package COM.TRANSPORTER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import COM.TRANSPORTER.BEAN.BEAN_PROFILE_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;

public class DAO_PROFILE {
	
	public BEAN_PROFILE_FILE GET_BY_ID(String id)
	{
		BEAN_PROFILE_FILE one = new BEAN_PROFILE_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from trans_table where trans_email=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_NAME(rs.getString("trans_email"));
				one.SET_FIRST_NAME(rs.getString("first_name"));
				one.SET_LAST_NAME(rs.getString("last_name"));
				one.SET_CONTACT(rs.getString("contact"));
				one.SET_USER_ID(rs.getInt("trans_id"));
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
			String query = "select * from trans_table where trans_id=?";
			
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_ID(rs.getInt("trans_id"));
				one.SET_USER_NAME(rs.getString("trans_email"));
				one.SET_FIRST_NAME(rs.getString("first_name"));
				one.SET_LAST_NAME(rs.getString("last_name"));
				one.SET_CONTACT(rs.getString("contact"));
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
			String query = "update trans_table set first_name=?,last_name=?,contact=? where trans_id=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, one.GET_FIRST_NAME());
			ps.setString(2, one.GET_LAST_NAME());
			ps.setString(3, one.GET_CONTACT());
			ps.setInt(4, one.GET_USER_ID());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public void UPDATE_PASSWORD_FILE(BEAN_PROFILE_FILE one)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "update trans_table set trans_password=? where trans_id=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, one.GET_USER_PASSWORD());
			ps.setInt(2, one.GET_USER_ID());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}
