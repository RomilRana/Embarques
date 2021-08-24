package COM.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import COM.BEAN.BEAN_AREA_FILE;
import COM.CONNECT.CONNECT_FILE;
public class DAO_AREA_FILE {
	

		public void insertdata(BEAN_AREA_FILE b1,BEAN_AREA_FILE b2)
		{
		
			try
			{	
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				
				
				Connection cn = CONNECT_FILE.sqlConnection();
				String Query = "insert into area_tab(pincode,area_name) values(?,?,'"+dtf.format(now)+"','"+dtf.format(now)+"')";
				PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
				ps.setInt(1,b1.GET_AREA_ID());
				ps.setString(2, b2.GET_AREA_NAME());
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public void DELETE_AREA(int id)
		{
			try
			{
				Connection cn =CONNECT_FILE.sqlConnection();
				String str="update area_tab set is_active=0 where pincode=?";
				PreparedStatement pst = cn.prepareStatement(str);
				pst.setInt(1, id);
				pst.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public List<BEAN_AREA_FILE> getAllInfo() throws SQLException
		{
			List<BEAN_AREA_FILE> list = new ArrayList<BEAN_AREA_FILE>();
			
			try
			{
				Connection con =CONNECT_FILE.sqlConnection();
				String query = "select * from area_tab where is_active=1";
				PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
				ResultSet re = ps.executeQuery();
				
				while(re.next())
				{
					BEAN_AREA_FILE eb = new BEAN_AREA_FILE();
					eb.SET_AREA_ID(re.getInt("pincode"));
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
				String query = "select * from area_tab where pincode=? and is_active=1";
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					one.SET_AREA_ID(rs.getInt("pincode"));
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
		public void UPDATE_FILE(BEAN_AREA_FILE one)
		{
			
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "update area_tab set area_name=? where pincode=?";
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, one.GET_AREA_NAME());
				ps.setInt(2,one.GET_AREA_ID());
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
		}

	}

