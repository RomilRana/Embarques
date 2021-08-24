package COM.CUSTOMER.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import COM.CUSTOMER.BEAN.BEAN_SUB_CATEGORY_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;
public class DAO_SUB_CATEGORY_FILE extends HttpServlet{

		
				/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
				
				int id12;
				public void DELETE_SUB_CATEGORY(int id)
				{
						id12=id;
				}
				public List<BEAN_SUB_CATEGORY_FILE> getAllInfo() throws SQLException
				{
					List<BEAN_SUB_CATEGORY_FILE> list = new ArrayList<BEAN_SUB_CATEGORY_FILE>();
				
					try
					{
						Connection con =CONNECT_FILE.sqlConnection();
						/*String query = "select * from sub_category INNER JOIN category on sub_category.category_id = category.category_id order by category_name desc";*/
						String query = "SELECT * FROM sub_cat INNER JOIN cat ON sub_cat.category_id = cat.category_id WHERE is_active_id=1";
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
				

			}
