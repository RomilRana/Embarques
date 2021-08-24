package COM.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.BEAN.BEAN_USER_FILE;
import COM.CONNECT.CONNECT_FILE;

public class DAO_USER_FILE {
	

	public List<BEAN_USER_FILE> getAllInfo() throws SQLException
	{
		List<BEAN_USER_FILE> list = new ArrayList<BEAN_USER_FILE>();
		
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table where is_active=1 order by cust_id desc";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_USER_FILE eb = new BEAN_USER_FILE();
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_USER_PASSWORD(re.getString("cust_password"));
				eb.SET_FIRST_NAME(re.getString("first_name"));
				eb.SET_LAST_NAME(re.getString("last_name"));
				eb.SET_CONTACT(re.getString("contact"));
				list.add(eb);
			}
			re.close();
			ps.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public BEAN_USER_FILE GET_BY_ID(int id)
	{
		BEAN_USER_FILE one = new BEAN_USER_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table where cust_id=? and is_active=1";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_PASSWORD(rs.getString("cust_password"));
				one.SET_USER_ID(rs.getInt("cust_id"));
				one.SET_CONTACT(rs.getString("contact"));
				one.SET_FIRST_NAME(rs.getString("first_name"));
				one.SET_FIRST_NAME(rs.getString("last_name"));	
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
	
	public void DELETE_USER(int id)
	{
		try
		{
			Connection cn =CONNECT_FILE.sqlConnection();
			String str="update cust_table set is_active=0 where cust_id=?";
			PreparedStatement pst = cn.prepareStatement(str);
			pst.setInt(1, id);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public int getCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table where is_active=1 order by cust_id desc";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				count++;
			}
			re.close();
			ps.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return count;
	
	}
	
	public List<BEAN_USER_FILE> getLatestUser() throws SQLException
	{
		List<BEAN_USER_FILE> list = new ArrayList<BEAN_USER_FILE>();
		
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select  * from cust_table where is_active=1 order by cust_id desc limit 10";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_USER_FILE eb = new BEAN_USER_FILE();
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_USER_PASSWORD(re.getString("cust_password"));
				eb.SET_FIRST_NAME(re.getString("first_name"));
				eb.SET_LAST_NAME(re.getString("last_name"));
				eb.SET_CONTACT(re.getString("contact"));
				list.add(eb);
			}
			re.close();
			ps.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
