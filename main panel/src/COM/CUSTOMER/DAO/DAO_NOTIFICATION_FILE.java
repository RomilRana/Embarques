package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.CUSTOMER.BEAN.BEAN_NOTIFICATION_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_NOTIFICATION_FILE {
	
	
	public List<BEAN_NOTIFICATION_FILE> getAllInfo() throws SQLException
	{
		List<BEAN_NOTIFICATION_FILE> list = new ArrayList<BEAN_NOTIFICATION_FILE>();
	
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			 String query = "select * from notification_trans  INNER JOIN trans_table ON notification_trans.trans_id = trans_table.trans_id";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();	
			while(re.next())
			{
				BEAN_NOTIFICATION_FILE eb = new BEAN_NOTIFICATION_FILE();
				eb.SET_NOTIFICATION_ID(re.getInt("notification_id"));
				eb.SET_TRANS_ID(re.getInt("trans_id"));
				eb.SET_TRANS_NAME(re.getString("trans_email"));
				eb.SET_REPLY(re.getString("reply"));
				eb.SET_DATE_TIME(re.getString("doi"));
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


