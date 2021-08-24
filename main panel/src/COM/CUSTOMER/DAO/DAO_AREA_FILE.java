package COM.CUSTOMER.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.CUSTOMER.BEAN.BEAN_AREA_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;
public class DAO_AREA_FILE {
	
	
		public List<BEAN_AREA_FILE> getAllInfo() throws SQLException
		{
			List<BEAN_AREA_FILE> list = new ArrayList<BEAN_AREA_FILE>();
			
			try
			{
				Connection con =CONNECT_FILE.sqlConnection();
				String query = "select * from area_tab";
				PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
				ResultSet re = ps.executeQuery();
				
				while(re.next())
				{
					BEAN_AREA_FILE eb = new BEAN_AREA_FILE();
					eb.SET_AREA_ID(re.getInt("area_id"));
					eb.SET_AREA_NAME(re.getString("area_name"));
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
		public BEAN_AREA_FILE GET_BY_ID(int id)
		{
			BEAN_AREA_FILE one = new BEAN_AREA_FILE();
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "select * from area_tab where area_id=?";
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					one.SET_AREA_ID(rs.getInt("area_id"));
					one.SET_AREA_NAME(rs.getString("area_name"));
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

