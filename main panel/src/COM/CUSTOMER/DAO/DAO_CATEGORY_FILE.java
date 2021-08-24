package COM.CUSTOMER.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.CUSTOMER.BEAN.BEAN_CATEGORY_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class DAO_CATEGORY_FILE {
			public List<BEAN_CATEGORY_FILE> getAllInfo() throws SQLException
			{
				List<BEAN_CATEGORY_FILE> list = new ArrayList<BEAN_CATEGORY_FILE>();
				
				try
				{
					Connection con =CONNECT_FILE.sqlConnection();
					String query = "select * from cat order by category_id desc";
					PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
					ResultSet re = ps.executeQuery();
					
					while(re.next())
					{
						BEAN_CATEGORY_FILE eb = new BEAN_CATEGORY_FILE();
						eb.SET_CATEGORY_ID(re.getInt("category_id"));
						eb.SET_CATEGORY_NAME(re.getString("category_name"));
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



