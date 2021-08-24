package COM.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import COM.BEAN.BEAN_CATEGORY_FILE;
import COM.CONNECT.CONNECT_FILE;

public class DAO_CATEGORY_FILE {
	
			public void insertdata(BEAN_CATEGORY_FILE b2)
			{
			
				try
				{	
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					
					
					Connection cn = CONNECT_FILE.sqlConnection();
					String Query = "insert into cat(category_name,doi,dou) values(?,'"+dtf.format(now)+"','"+dtf.format(now)+"')";
					PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
				/*	ps.setInt(1, b1.GET_CATEGORY_ID());*/
					ps.setString(1, b2.GET_CATEGORY_NAME());
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
					String str="update cat set is_active=0 where category_id=?";
					PreparedStatement pst = cn.prepareStatement(str);
					pst.setInt(1, id);
					pst.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			public List<BEAN_CATEGORY_FILE> getAllInfo() throws SQLException
			{
				List<BEAN_CATEGORY_FILE> list = new ArrayList<BEAN_CATEGORY_FILE>();
				
				try
				{
					Connection con =CONNECT_FILE.sqlConnection();
					String query = "select * from cat where is_active=1 order by category_id desc";
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
			
			public BEAN_CATEGORY_FILE GET_BY_ID(int id)
			{
				BEAN_CATEGORY_FILE one = new BEAN_CATEGORY_FILE();
				try
				{
					Connection cn = CONNECT_FILE.sqlConnection();
					String query = "select * from cat where category_id=? and is_active=1";
					PreparedStatement ps = cn.prepareStatement(query);
					ps.setInt(1,id);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						one.SET_CATEGORY_NAME(rs.getString("category_name"));
						one.SET_CATEGORY_ID(rs.getInt("category_id"));
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
			
			
			public void UPDATE_FILE(BEAN_CATEGORY_FILE one)
			{
				try
				{
					Connection cn = CONNECT_FILE.sqlConnection();
					String query = "update cat set category_name=? where category_id=?";
					PreparedStatement ps = cn.prepareStatement(query);
					ps.setString(1, one.GET_CATEGORY_NAME());
					ps.setInt(2, one.GET_CATEGORY_ID());
					ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
			}

		}



