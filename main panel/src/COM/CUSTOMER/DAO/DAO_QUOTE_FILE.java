package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import COM.CUSTOMER.BEAN.BEAN_QUOTE_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_QUOTE_FILE {
	
	public void insertdata(BEAN_QUOTE_FILE b2)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		try
		{
			 
			 String from=b2.GET_FROM_DATE();
				String to=b2.GET_TO_DATE();
				
				
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into send_req(category_id,sub_category_id,source_id,destination_id,cust_id,from_date,to_date,description,address,doi) values(?,?,?,?,?,'"+from+"','"+to+"',?,?,'"+dtf.format(now)+"')";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			ps.setInt(1, b2.GET_CATEGORY_ID());
			ps.setInt(2, b2.GET_SUB_CATEGORY_ID());
			ps.setInt(3, b2.GET_SOURCE_ID());
			ps.setInt(4, b2.GET_DESTINATION_ID());
			ps.setInt(5, b2.GET_USER_ID());
			ps.setString(6, b2.GET_MESSAGE());
			ps.setString(7, b2.GET_ADDRESS());
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*
		 * try { Connection cn = CONNECT_FILE.sqlConnection(); String Query =
		 * "insert into notification(cust_id,description,doi) values(?,?,'"+dtf.format(
		 * now)+"')"; PreparedStatement ps =(PreparedStatement)
		 * cn.prepareStatement(Query);
		 * 
		 * ps.setInt(1, b2.GET_USER_ID()); ps.setString(2,b2.GET_MESSAGE());
		 * ps.executeUpdate(); } catch(Exception e) { e.printStackTrace(); }
		 */
	}
	
	
	public List<BEAN_QUOTE_FILE> getAllInfo(int id,int q_id) throws SQLException
	{
	
		List<BEAN_QUOTE_FILE> list = new ArrayList<BEAN_QUOTE_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			String query = "SELECT * FROM send_reply INNER JOIN trans_table ON send_reply.trans_id = trans_table.trans_id INNER JOIN send_req ON send_reply.quote_id = send_req.quote_id  INNER JOIN cust_table ON send_req.cust_id = cust_table.cust_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id  WHERE cust_table.cust_id='"+id+"' AND send_req.quote_id='"+q_id+"' AND active_req=1";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();	
			
			while(re.next())
			{
				BEAN_QUOTE_FILE eb = new BEAN_QUOTE_FILE();
				eb.SET_QUOTE_ID(re.getInt("quote_id"));
				eb.SET_TRANS_ID(re.getInt("trans_id"));
				eb.SET_TRANS_NAME(re.getString("trans_email"));
				eb.SET_COMPANY_NAME(re.getString("company_name"));
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
	
	public List<BEAN_QUOTE_FILE> getAllInfo1(int id) throws SQLException
	{
		List<BEAN_QUOTE_FILE> list = new ArrayList<BEAN_QUOTE_FILE>();
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			 String query = "SELECT * FROM send_req  INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id WHERE cust_id='"+id+"' AND active_s=1 order by quote_id ";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();	
			while(re.next())
			{
				BEAN_QUOTE_FILE eb = new BEAN_QUOTE_FILE();
				eb.SET_QUOTE_ID(re.getInt("quote_id"));
				eb.SET_CATEGORY_ID(re.getInt("category_id"));
				eb.SET_CATEGORY_NAME(re.getString("category_name"));
				eb.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
				eb.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
				eb.SET_SOURCE_ID(re.getInt("source_id"));
				eb.SET_SOURCE_NAME(re.getString("source_name"));
				eb.SET_DESTINATION_ID(re.getInt("destination_id"));
				eb.SET_DESTINATION_NAME(re.getString("destination_name"));
				eb.SET_MESSAGE(re.getString("description"));
				eb.SET_FROM_DATE(re.getString("from_date"));
				eb.SET_TO_DATE(re.getString("to_date"));
				eb.SET_REPLY(re.getString("reply"));
				eb.SET_ADDRESS(re.getString("address"));
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
	
	public BEAN_QUOTE_FILE GET_BY_ID(int id)
	{
		BEAN_QUOTE_FILE one = new BEAN_QUOTE_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "SELECT * FROM send_reply INNER JOIN trans_table ON send_reply.trans_id = trans_table.trans_id INNER JOIN send_req ON send_reply.quote_id = send_req.quote_id  INNER JOIN cust_table ON send_req.cust_id = cust_table.cust_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id where send_req.quote_id=? AND active_req=1";			
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_QUOTE_ID(rs.getInt("quote_id"));
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
				one.SET_TRANS_QUOTE_ID(rs.getInt("trans_quote_id"));
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
	
	public BEAN_QUOTE_FILE GET_BY_ID1(int id)
	{
		BEAN_QUOTE_FILE one = new BEAN_QUOTE_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "SELECT * FROM send_reply INNER JOIN trans_table ON send_reply.trans_id = trans_table.trans_id INNER JOIN send_req ON send_reply.quote_id = send_req.quote_id  INNER JOIN cust_table ON send_req.cust_id = cust_table.cust_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id where send_req.quote_id=? AND active_req=1";
			
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_QUOTE_ID(rs.getInt("quote_id"));
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
				one.SET_TRANS_QUOTE_ID(rs.getInt("trans_quote_id"));
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
}