package COM.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import COM.CONNECT.*;


public class DAO_QUOTE_FILE {
	
	
	public int getCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			String query = "SELECT * FROM send_req where active_s=1;";
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
	
	
}