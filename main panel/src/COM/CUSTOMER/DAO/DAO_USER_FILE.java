package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import COM.CUSTOMER.BEAN.BEAN_USER_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_USER_FILE {
	
	public void insertdata(BEAN_USER_FILE b2)
	{
	
		try
		{	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into cust_table(first_name,last_name,cust_email,contact,cust_password,doi,dou) values(?,?,?,?,?,'"+dtf.format(now)+"','"+dtf.format(now)+"')";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			ps.setString(1, b2.GET_FIRST_NAME());
			ps.setString(2, b2.GET_LAST_NAME());
			ps.setString(3, b2.GET_USER_NAME());
			ps.setString(4, b2.GET_CONTACT());
			ps.setString(5, b2.GET_USER_PASSWORD());
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<BEAN_USER_FILE> getAllInfo() throws SQLException
	{
		List<BEAN_USER_FILE> list = new ArrayList<BEAN_USER_FILE>();
		
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from cust_table order by cust_id desc";
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
			String query = "select * from cust_table where cust_id=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_USER_PASSWORD(rs.getString("cust_password"));
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
	
	public void DELETE_USER(int id)
	{
		try
		{
			Connection cn =CONNECT_FILE.sqlConnection();
			String str="delete from cust_table where cust_id=?";
			PreparedStatement pst = cn.prepareStatement(str);
			pst.setInt(1, id);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void UPDATE_FILE(BEAN_USER_FILE one)
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
