package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import COM.CUSTOMER.BEAN.BEAN_IMAGE_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_IMAGE_FILE {
	
	public void insertdata(BEAN_IMAGE_FILE b2)
	{
	
		try
		{	
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into image(image) values(?)";
			PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
			ps.setString(1, b2.GET_IMAGE_NAME());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public BEAN_IMAGE_FILE GET_BY_IMAGE()
	{
		BEAN_IMAGE_FILE one = new BEAN_IMAGE_FILE();
		try
		{
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from image";
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				one.SET_IMAGE_NAME(rs.getString("image"));
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
