package COM.TRANSPORTER.CONNECT;

import java.sql.Connection;
import java.sql.DriverManager;

public class CONNECT_FILE {

	public static Connection sqlConnection()
	{
		Connection cn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cn;
	}
}
