package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import COM.CUSTOMER.BEAN.BEAN_ORDER_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_ORDER_FILE {
	
	public void insertdata(BEAN_ORDER_FILE b2)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		int id = 0;
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into order_tab(trans_quote_id,quote_id,trans_id,cust_id,first_name,last_name,contact,address,date_of_order) values(?,?,?,?,?,?,?,?,'"+dtf.format(now)+"')";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			
			id=b2.GET_QUOTE_ID();
			ps.setInt(1, b2.GET_TRANS_QUOTE_ID());
			ps.setInt(2, b2.GET_QUOTE_ID());
			ps.setInt(3, b2.GET_TRANS_ID());
			ps.setInt(4, b2.GET_USER_ID());
			ps.setString(5, b2.GET_FIRST_NAME());
			ps.setString(6, b2.GET_LAST_NAME());
			ps.setString(7, b2.GET_CONTACT());
			ps.setString(8, b2.GET_ADDRESS());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query="update send_reply set active_req=0 where quote_id='"+id+"'";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(query);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query="update send_req set active_s=0 where quote_id='"+id+"'";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(query);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public BEAN_ORDER_FILE GET_BY_ID(int id)
	{
		BEAN_ORDER_FILE one = new BEAN_ORDER_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from send_reply INNER JOIN trans_table ON send_reply.trans_id = trans_table.trans_id INNER JOIN cat ON send_reply.category_id = cat.category_id INNER JOIN sub_cat ON send_reply.sub_category_id = sub_cat.sub_category_id INNER JOIN source_table ON send_reply.source_id = source_table.source_id INNER JOIN destination_table ON send_reply.destination_id = destination_table.destination_id where quote_id=? and delivered=0";
			
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_QUOTE_ID(rs.getInt("quote_id"));
				one.SET_TRANS_QUOTE_ID(rs.getInt("trans_quote_id"));
				one.SET_TRANS_ID(rs.getInt("trans_id"));
				one.SET_TRANS_NAME(rs.getString("trans_email"));
				one.SET_CATEGORY_ID(rs.getInt("category_id"));
				one.SET_CATEGORY_NAME(rs.getString("category_name"));
				one.SET_SUB_CATEGORY_ID(rs.getInt("sub_category_id"));
				one.SET_SUB_CATEGORY_NAME(rs.getString("sub_category_name"));
				one.SET_SOURCE_ID(rs.getInt("source_id"));
				one.SET_SOURCE_NAME(rs.getString("source_name"));
				one.SET_DESTINATION_ID(rs.getInt("destination_id"));
				one.SET_DESTINATION_NAME(rs.getString("destination_name"));
				one.SET_REPLY(rs.getString("reply"));
				one.SET_FROM_DATE(rs.getString("from_date"));
				one.SET_TO_DATE(rs.getString("to_date"));
				one.SET_MESSAGE(rs.getString("description"));
				one.SET_ADDRESS(rs.getString("address"));
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
	public List<BEAN_ORDER_FILE> getAllInfo() throws SQLException
	{
		List<BEAN_ORDER_FILE> list = new ArrayList<BEAN_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			String query = "SELECT * FROM order_tab INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id WHERE delivered=0 AND cancel=0";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			
			while(re.next())
			{
				BEAN_ORDER_FILE eb = new BEAN_ORDER_FILE();
				eb.SET_QUOTE_ID(re.getInt("quote_id"));
				eb.SET_ORDER_ID(re.getInt("order_id"));
				eb.SET_TRANS_QUOTE_ID(re.getInt("trans_quote_id"));
				eb.SET_TRANS_ID(re.getInt("trans_id"));
				eb.SET_TRANS_NAME(re.getString("trans_email"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_CATEGORY_ID(re.getInt("category_id"));
				eb.SET_CATEGORY_NAME(re.getString("category_name"));
				eb.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
				eb.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
				eb.SET_SOURCE_ID(re.getInt("source_id"));
				eb.SET_SOURCE_NAME(re.getString("source_name"));
				eb.SET_DESTINATION_ID(re.getInt("destination_id"));
				eb.SET_DESTINATION_NAME(re.getString("destination_name"));
				eb.SET_FROM_DATE(re.getString("from_date"));
				eb.SET_TO_DATE(re.getString("to_date"));
				eb.SET_MESSAGE(re.getString("description"));
				eb.SET_REPLY(re.getString("reply"));
				eb.SET_ADDRESS(re.getString("address"));
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
	public List<BEAN_ORDER_FILE> getAllInfo1() throws SQLException
	{
		List<BEAN_ORDER_FILE> list = new ArrayList<BEAN_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			String query = "SELECT * FROM order_tab INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id  where delivered=1";
			
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			
			while(re.next())
			{
				BEAN_ORDER_FILE eb = new BEAN_ORDER_FILE();
				eb.SET_QUOTE_ID(re.getInt("quote_id"));
				eb.SET_TRANS_QUOTE_ID(re.getInt("trans_quote_id"));
				eb.SET_TRANS_ID(re.getInt("trans_id"));
				eb.SET_TRANS_NAME(re.getString("trans_email"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_CATEGORY_ID(re.getInt("category_id"));
				eb.SET_CATEGORY_NAME(re.getString("category_name"));
				eb.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
				eb.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
				eb.SET_SOURCE_ID(re.getInt("source_id"));
				eb.SET_SOURCE_NAME(re.getString("source_name"));
				eb.SET_DESTINATION_ID(re.getInt("destination_id"));
				eb.SET_DESTINATION_NAME(re.getString("destination_name"));
				eb.SET_FROM_DATE(re.getString("from_date"));
				eb.SET_TO_DATE(re.getString("to_date"));
				eb.SET_MESSAGE(re.getString("description"));
				eb.SET_REPLY(re.getString("reply"));
				eb.SET_ADDRESS(re.getString("address"));
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
	public List<BEAN_ORDER_FILE> getAllInfo1(int uid) throws SQLException
	{
		List<BEAN_ORDER_FILE> list = new ArrayList<BEAN_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			String query = "SELECT * FROM order_tab INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id where delivered=1 and order_tab.cust_id='"+uid+"' and cancel=0";
			
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			
			while(re.next())
			{
				BEAN_ORDER_FILE eb = new BEAN_ORDER_FILE();
				eb.SET_QUOTE_ID(re.getInt("quote_id"));
				eb.SET_TRANS_QUOTE_ID(re.getInt("trans_quote_id"));
				eb.SET_TRANS_ID(re.getInt("trans_id"));
				eb.SET_TRANS_NAME(re.getString("trans_email"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_CATEGORY_ID(re.getInt("category_id"));
				eb.SET_CATEGORY_NAME(re.getString("category_name"));
				eb.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
				eb.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
				eb.SET_SOURCE_ID(re.getInt("source_id"));
				eb.SET_SOURCE_NAME(re.getString("source_name"));
				eb.SET_DESTINATION_ID(re.getInt("destination_id"));
				eb.SET_DESTINATION_NAME(re.getString("destination_name"));
				eb.SET_FROM_DATE(re.getString("from_date"));
				eb.SET_TO_DATE(re.getString("to_date"));
				eb.SET_MESSAGE(re.getString("description"));
				eb.SET_REPLY(re.getString("reply"));
				eb.SET_ADDRESS(re.getString("address"));
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
	public List<BEAN_ORDER_FILE> getAllInfo2(int uid) throws SQLException
	{
		List<BEAN_ORDER_FILE> list = new ArrayList<BEAN_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			String query = "SELECT * FROM order_tab INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id where delivered=1 and order_tab.trans_id='"+uid+"' and cancel=0";
			
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			
			while(re.next())
			{
				BEAN_ORDER_FILE eb = new BEAN_ORDER_FILE();
				eb.SET_QUOTE_ID(re.getInt("quote_id"));
				eb.SET_TRANS_QUOTE_ID(re.getInt("trans_quote_id"));
				eb.SET_TRANS_ID(re.getInt("trans_id"));
				eb.SET_TRANS_NAME(re.getString("trans_email"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_CATEGORY_ID(re.getInt("category_id"));
				eb.SET_CATEGORY_NAME(re.getString("category_name"));
				eb.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
				eb.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
				eb.SET_SOURCE_ID(re.getInt("source_id"));
				eb.SET_SOURCE_NAME(re.getString("source_name"));
				eb.SET_DESTINATION_ID(re.getInt("destination_id"));
				eb.SET_DESTINATION_NAME(re.getString("destination_name"));
				eb.SET_FROM_DATE(re.getString("from_date"));
				eb.SET_TO_DATE(re.getString("to_date"));
				eb.SET_MESSAGE(re.getString("description"));
				eb.SET_REPLY(re.getString("reply"));
				eb.SET_ADDRESS(re.getString("address"));
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
	public List<BEAN_ORDER_FILE> getAllCancelInfo(int uid) throws SQLException
	{
		List<BEAN_ORDER_FILE> list = new ArrayList<BEAN_ORDER_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			String query = "SELECT * FROM cancel_table INNER JOIN order_tab ON cancel_table.order_id = order_tab.order_id INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id where send_req.cust_id='"+uid+"'";
			
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			
			while(re.next())
			{
				BEAN_ORDER_FILE eb = new BEAN_ORDER_FILE();
				eb.SET_QUOTE_ID(re.getInt("quote_id"));
				eb.SET_ORDER_ID(re.getInt("order_id"));
				eb.SET_TRANS_QUOTE_ID(re.getInt("trans_quote_id"));
				eb.SET_TRANS_ID(re.getInt("trans_id"));
				eb.SET_TRANS_NAME(re.getString("trans_email"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_CATEGORY_ID(re.getInt("category_id"));
				eb.SET_CATEGORY_NAME(re.getString("category_name"));
				eb.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
				eb.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
				eb.SET_SOURCE_ID(re.getInt("source_id"));
				eb.SET_SOURCE_NAME(re.getString("source_name"));
				eb.SET_DESTINATION_ID(re.getInt("destination_id"));
				eb.SET_DESTINATION_NAME(re.getString("destination_name"));
				eb.SET_FROM_DATE(re.getString("from_date"));
				eb.SET_TO_DATE(re.getString("to_date"));
				eb.SET_MESSAGE(re.getString("description"));
				eb.SET_REPLY(re.getString("reply"));
				eb.SET_ADDRESS(re.getString("address"));
				eb.SET_CANCEL_DATE(re.getString("date_of_cancel"));
				eb.SET_REASON(re.getString("reason"));
				eb.SET_CANCEL_BY(re.getString("cancel_by"));
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
		


	public BEAN_ORDER_FILE GET_BY_TRANS_QUOTE_ID(int id)
	{
		BEAN_ORDER_FILE one = new BEAN_ORDER_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "SELECT * FROM order_tab INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id where send_reply.trans_quote_id=?";			
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_QUOTE_ID(rs.getInt("quote_id"));
				one.SET_TRANS_QUOTE_ID(rs.getInt("trans_quote_id"));
				one.SET_TRANS_ID(rs.getInt("trans_id"));
				one.SET_TRANS_NAME(rs.getString("trans_email"));
				one.SET_COMPANY_NAME(rs.getString("company_name"));
				one.SET_CATEGORY_ID(rs.getInt("category_id"));
				one.SET_CATEGORY_NAME(rs.getString("category_name"));
				one.SET_SUB_CATEGORY_ID(rs.getInt("sub_category_id"));
				one.SET_SUB_CATEGORY_NAME(rs.getString("sub_category_name"));
				one.SET_SOURCE_ID(rs.getInt("source_id"));
				one.SET_SOURCE_NAME(rs.getString("source_name"));
				one.SET_DESTINATION_ID(rs.getInt("destination_id"));
				one.SET_DESTINATION_NAME(rs.getString("destination_name"));
				one.SET_REPLY(rs.getString("reply"));
				one.SET_FROM_DATE(rs.getString("from_date"));
				one.SET_TO_DATE(rs.getString("to_date"));
				one.SET_MESSAGE(rs.getString("description"));
				one.SET_ADDRESS(rs.getString("address"));
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
	public static boolean isValidUser(int cust_id,int order_id)
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from rating_tab where cust_id='"+cust_id+"' AND order_id='"+order_id+"'";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return false;
			}
			else
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
	public void insertcanceldata(BEAN_ORDER_FILE b2)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		int id = 0;
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into cancel_table(trans_quote_id,quote_id,date_of_cancel,order_id,reason) values(?,?,'"+dtf.format(now)+"',?,?)";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			
			id=b2.GET_QUOTE_ID();
			ps.setInt(1, b2.GET_TRANS_QUOTE_ID());
			ps.setInt(2, b2.GET_QUOTE_ID());
			ps.setInt(3,b2.GET_ORDER_ID());
			ps.setString(4, b2.GET_REASON());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query="update send_reply set active_req=0 where quote_id='"+id+"'";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(query);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query="update send_req set active_s=0 where quote_id='"+id+"'";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(query);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query="update order_tab set cancel=1,cancel_by='Customer' where quote_id='"+id+"'";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(query);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
