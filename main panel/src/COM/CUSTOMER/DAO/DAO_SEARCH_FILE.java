package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.CUSTOMER.BEAN.BEAN_USER_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_SEARCH_FILE {
	
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
