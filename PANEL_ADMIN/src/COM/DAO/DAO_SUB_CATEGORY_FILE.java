package COM.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import COM.BEAN.BEAN_SUB_CATEGORY_FILE;
import COM.CONNECT.CONNECT_FILE;
public class DAO_SUB_CATEGORY_FILE extends HttpServlet{

		
				/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
				public void insertdata(BEAN_SUB_CATEGORY_FILE b1)
				{
				
					try
					{	
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();
						
						
						Connection cn = CONNECT_FILE.sqlConnection();
						/*String Query = "insert into sub_cat(sub_category_name,category_id,doi,dou) values(?,?,'"+dtf.format(now)+"','"+dtf.format(now)+"')";*/
						String Query = "insert into sub_cat(sub_category_name,category_id,doi,dou) values(?,?,'"+dtf.format(now)+"','"+dtf.format(now)+"')";
						PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
						ps.setString(1, b1.GET_SUB_CATEGORY_NAME());
						ps.setInt(2,b1.GET_CATEGORY_ID());
						ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				public void DELETE_SUB_CATEGORY(int id)
				{
					try
					{
						Connection cn =CONNECT_FILE.sqlConnection();
						/*String str="delete from SUB_CATEGORY where sub_category_id=?";*/
						String str="update sub_cat set is_active=0 where sub_category_id=?";
						PreparedStatement pst = cn.prepareStatement(str);
						pst.setInt(1, id);
						pst.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				public List<BEAN_SUB_CATEGORY_FILE> getAllInfo() throws SQLException
				{
					List<BEAN_SUB_CATEGORY_FILE> list = new ArrayList<BEAN_SUB_CATEGORY_FILE>();
				
					try
					{
						Connection con =CONNECT_FILE.sqlConnection();
						/*String query = "select * from sub_category INNER JOIN category on sub_category.category_id = category.category_id order by category_name desc";*/
						String query = "select * from sub_cat INNER JOIN cat on sub_cat.category_id = cat.category_id WHERE is_active_id=1";
						PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
						ResultSet re = ps.executeQuery();
						
						while(re.next())
						{
							BEAN_SUB_CATEGORY_FILE eb = new BEAN_SUB_CATEGORY_FILE();
							eb.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
							eb.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
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
				
				public BEAN_SUB_CATEGORY_FILE GET_BY_ID(int id)
				{
					BEAN_SUB_CATEGORY_FILE one = new BEAN_SUB_CATEGORY_FILE();
					try
					{
						Connection cn = CONNECT_FILE.sqlConnection();
						String query = "select * from sub_cat where sub_category_id=? and is_active_id=1";
						
						PreparedStatement ps = cn.prepareStatement(query);
						ps.setInt(1,id);
						ResultSet rs = ps.executeQuery();
						if(rs.next())
						{
							one.SET_SUB_CATEGORY_NAME(rs.getString("sub_category_name"));
							one.SET_SUB_CATEGORY_ID(rs.getInt("sub_category_id"));
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
				
				
				public void UPDATE_FILE(BEAN_SUB_CATEGORY_FILE one)
				{
					try
					{
						Connection cn = CONNECT_FILE.sqlConnection();
						String query = "update sub_cat set sub_category_name=? where sub_category_id=?";
						PreparedStatement ps = cn.prepareStatement(query);
						ps.setString(1, one.GET_SUB_CATEGORY_NAME());
						ps.setInt(2, one.GET_SUB_CATEGORY_ID());
						ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}	
				}

			}
