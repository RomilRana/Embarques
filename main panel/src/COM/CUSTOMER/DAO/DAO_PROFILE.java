package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import COM.CUSTOMER.BEAN.BEAN_PROFILE_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_PROFILE {
	
	public BEAN_PROFILE_FILE GET_BY_ID(String id)
	{
		BEAN_PROFILE_FILE one = new BEAN_PROFILE_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table where cust_email=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_NAME(rs.getString("cust_email"));
				one.SET_FIRST_NAME(rs.getString("first_name"));
				one.SET_LAST_NAME(rs.getString("last_name"));
				one.SET_CONTACT(rs.getString("contact"));
				one.SET_USER_ID(rs.getInt("cust_id"));
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
			String query = "select * from cust_table where cust_id=?";
			
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_ID(rs.getInt("cust_id"));
				one.SET_USER_NAME(rs.getString("cust_email"));
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
			String query = "update cust_table set first_name=? where cust_id=?";
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
	public void UPDATE_PASSWORD_FILE(BEAN_PROFILE_FILE one)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "update cust_table set cust_password=? where cust_id=?";
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
