package COM.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.CONNECT.CONNECT_FILE;

public class DAO_PACKAGE_FILE {
	
	
	public int getCount() throws SQLException
	{
		int count=0;
		try
		{
			Connection con =CONNECT_FILE.sqlConnection();
			
			 String query = "select * from package";
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
