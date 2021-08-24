package COM.TRANSPORTER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import COM.TRANSPORTER.BEAN.BEAN_USER_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;

public class DAO_TRANSPORTER_FILE {
	public void insertdata(BEAN_USER_FILE b2)
	{
	
		try
		{	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into trans_table(first_name,last_name,trans_email,contact,trans_password,doi,dou,company_name) values(?,?,?,?,?,'"+dtf.format(now)+"','"+dtf.format(now)+"',?)";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			ps.setString(1, b2.GET_FIRST_NAME());
			ps.setString(2, b2.GET_LAST_NAME());
			ps.setString(3, b2.GET_USER_NAME());
			ps.setString(4, b2.GET_CONTACT());
			ps.setString(5, b2.GET_USER_PASSWORD());
			ps.setString(6, b2.GET_COMPANY_NAME());
			
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
			String query = "select * from trans_table order by trans_id desc";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_USER_FILE eb = new BEAN_USER_FILE();
				eb.SET_USER_ID(re.getInt("trans_id"));
				eb.SET_USER_NAME(re.getString("trans_email"));
				eb.SET_USER_PASSWORD(re.getString("trans_password"));
				eb.SET_FIRST_NAME(re.getString("first_name"));
				eb.SET_LAST_NAME(re.getString("last_name"));
				eb.SET_CONTACT(re.getString("contact"));
				eb.SET_COMPANY_NAME(re.getString("company_name"));
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
			String query = "select * from trans_table where trans_id=?";
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
			String str="delete from trans_table where trans_id=?";
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
			String query = "update trans_table set first_name=?,last_name=?,trans_password=?,contact=? where trans_id=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, one.GET_FIRST_NAME());
			ps.setString(2, one.GET_LAST_NAME());
			ps.setString(3, one.GET_USER_PASSWORD());
			ps.setString(4, one.GET_CONTACT());
			ps.setInt(5,one.GET_USER_ID());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}

