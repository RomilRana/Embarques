package COM.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.BEAN.BEAN_TRANSPORTER_FILE;
import COM.CONNECT.CONNECT_FILE;

public class DAO_TRANSPORTER_FILE {
	

	public List<BEAN_TRANSPORTER_FILE> getAllInfo() throws SQLException
	{
		List<BEAN_TRANSPORTER_FILE> list = new ArrayList<BEAN_TRANSPORTER_FILE>();
		
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from trans_table where is_active=1 and is_join=1 order by trans_id desc";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_TRANSPORTER_FILE eb = new BEAN_TRANSPORTER_FILE();
				eb.SET_USER_ID(re.getInt("trans_id"));
				eb.SET_USER_NAME(re.getString("trans_email"));
				eb.SET_USER_PASSWORD(re.getString("trans_password"));
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
	public List<BEAN_TRANSPORTER_FILE> getAllInfo1() throws SQLException
	{
		List<BEAN_TRANSPORTER_FILE> list = new ArrayList<BEAN_TRANSPORTER_FILE>();
		
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from trans_table where is_active=1 and is_join=0 order by trans_id desc";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_TRANSPORTER_FILE eb = new BEAN_TRANSPORTER_FILE();
				eb.SET_USER_ID(re.getInt("trans_id"));
				eb.SET_USER_NAME(re.getString("trans_email"));
				eb.SET_USER_PASSWORD(re.getString("trans_password"));
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
	public BEAN_TRANSPORTER_FILE GET_BY_ID(int id)
	{
		BEAN_TRANSPORTER_FILE one = new BEAN_TRANSPORTER_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from trans_table where trans_id=? and is_active=1 and is_join=1";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_PASSWORD(rs.getString("trans_password"));
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
	
	public void DELETE_USER(int id)
	{
		try
		{
			Connection cn =CONNECT_FILE.sqlConnection();
			String str="update trans_table set is_active=0 where trans_id=?";
			PreparedStatement pst = cn.prepareStatement(str);
			pst.setInt(1, id);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void PAID_USER(int id)
	{
		try
		{
			Connection cn =CONNECT_FILE.sqlConnection();
			String str="update trans_table set is_join=1 where trans_id=?";
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
			String query = "select * from trans_table where is_active=1 and is_join=1 order by trans_id desc";
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
	public List<BEAN_TRANSPORTER_FILE> getLatestTransporter() throws SQLException
	{
		List<BEAN_TRANSPORTER_FILE> list = new ArrayList<BEAN_TRANSPORTER_FILE>();
		
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from trans_table where is_active=1 and is_join=1 order by trans_id desc limit 10";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_TRANSPORTER_FILE eb = new BEAN_TRANSPORTER_FILE();
				eb.SET_USER_ID(re.getInt("trans_id"));
				eb.SET_USER_NAME(re.getString("trans_email"));
				eb.SET_USER_PASSWORD(re.getString("trans_password"));
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
