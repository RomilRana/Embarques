package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import COM.CUSTOMER.BEAN.BEAN_FEEDBACK_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_FEEDBACK_FILE {
	
	public void insertdata(BEAN_FEEDBACK_FILE b2)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into feedback(user_email,message,given_by,doi) values(?,?,?,'"+dtf.format(now)+"')";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			ps.setString(1, b2.GET_USER_NAME());
			ps.setString(2, b2.GET_MESSAGE());
			ps.setString(3, b2.GET_GIVEN_BY());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
