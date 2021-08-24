package COM.TRANSPORTER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.TRANSPORTER.BEAN.BEAN_NOTIFICATION_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;

public class DAO_NOTIFICATION_FILE {
	
	public List<BEAN_NOTIFICATION_FILE> getAllInfo() throws SQLException
	{
		List<BEAN_NOTIFICATION_FILE> list = new ArrayList<BEAN_NOTIFICATION_FILE>();
	
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			 String query = "select * from notification  INNER JOIN cust_table ON notification.cust_id = cust_table.cust_id";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();	
			while(re.next())
			{
				BEAN_NOTIFICATION_FILE eb = new BEAN_NOTIFICATION_FILE();
				eb.SET_NOTIFICATION_ID(re.getInt("notification_id"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_MESSAGE(re.getString("description"));
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
