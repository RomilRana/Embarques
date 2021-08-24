package COM.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.BEAN.BEAN_FEEDBACK_FILE;
import COM.CONNECT.CONNECT_FILE;

public class DAO_FEEDBACK_FILE {
	
	public List<BEAN_FEEDBACK_FILE> getAllInfo() throws SQLException
	{
		List<BEAN_FEEDBACK_FILE> list = new ArrayList<BEAN_FEEDBACK_FILE>();
		
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			String query = "select * from feedback";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			
			while(re.next())
			{
				BEAN_FEEDBACK_FILE eb = new BEAN_FEEDBACK_FILE();
				eb.SET_USER_MAIL(re.getString("user_email"));
				eb.SET_USER_NAME(re.getString("given_by"));
				eb.SET_DESCRIPTION(re.getString("message"));
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
