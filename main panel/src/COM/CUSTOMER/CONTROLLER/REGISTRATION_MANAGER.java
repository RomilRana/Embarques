package COM.CUSTOMER.CONTROLLER;

import java.sql.Connection;
import java.sql.PreparedStatement;

import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class REGISTRATION_MANAGER {

	public static boolean updateUserPass(String pass, String email) 
	{
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "update cust_table set cust_password='"+pass+"' where cust_email='"+email+"'";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return false;
	}
	
}
