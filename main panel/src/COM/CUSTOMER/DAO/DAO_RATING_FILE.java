package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import COM.CUSTOMER.BEAN.BEAN_RATING_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_RATING_FILE {
	
	
	public void insertdata(BEAN_RATING_FILE b2)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into rating_tab(order_id,trans_id,cust_id,rating) values(?,?,?,?)";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			
			ps.setInt(1, b2.GET_QUOTE_ID());
			ps.setInt(2, b2.GET_TRANS_ID());
			ps.setInt(3, b2.GET_USER_ID());
			ps.setString(4, b2.GET_RATING());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "update trans_table set rating=? where trans_id=?";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);

			ps.setString(1, b2.GET_RATING());
			ps.setInt(2, b2.GET_TRANS_ID());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insertPackagedata(BEAN_RATING_FILE b2)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into rating_tab(package_order_id,trans_id,cust_id,rating) values(?,?,?,?)";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			
			ps.setInt(1, b2.GET_PACKAGE_ORDER_ID());
			ps.setInt(2, b2.GET_TRANS_ID());
			ps.setInt(3, b2.GET_USER_ID());
			ps.setString(4, b2.GET_RATING());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "update trans_table set rating=? where trans_id=?";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);

			ps.setString(1, b2.GET_RATING());
			ps.setInt(2, b2.GET_TRANS_ID());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int getFiveCount(int trans_id) throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=5 and trans_id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ps.setInt(1, trans_id);
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
	public int getFourHalfCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=4.5";
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
	public int getFourCount(int trans_id) throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=4 and trans_id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ps.setInt(1, trans_id);
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
	public int getThreeHalfCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=3.5";
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

	public int getThreeCount(int trans_id) throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=3 and trans_id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ps.setInt(1, trans_id);
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
	public int getTwoHalfCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=2.5";
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
	public int getTwoCount(int trans_id) throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=2 and trans_id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ps.setInt(1, trans_id);
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
	public int getOneHalfCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=1.5";
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
	public int getOneCount(int trans_id) throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=1 and trans_id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ps.setInt(1, trans_id);
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
	public int getZeroCount(int trans_id) throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=0 and trans_id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ps.setInt(1, trans_id);
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
	public int getZeroHalfCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where rating=0.5";
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
	public int getCount(int trans_id) throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where trans_id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ps.setInt(1, trans_id);
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
		
}
