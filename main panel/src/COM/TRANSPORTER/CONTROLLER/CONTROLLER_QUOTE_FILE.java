package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.CUSTOMER.BEAN.BEAN_ORDER_FILE;
import COM.CUSTOMER.DAO.DAO_ORDER_FILE;
import COM.TRANSPORTER.BEAN.BEAN_LOG_FILE;
import COM.TRANSPORTER.BEAN.BEAN_QUOTE_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;
import COM.TRANSPORTER.DAO.DAO_LOG_FILE;
import COM.TRANSPORTER.DAO.DAO_QUOTE_FILE;

@WebServlet("/TRANSPORTER/QUOTE_TWO")
public class CONTROLLER_QUOTE_FILE  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("reply"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			DAO_QUOTE_FILE d1 = new DAO_QUOTE_FILE();
			BEAN_QUOTE_FILE one = d1.GET_BY_ID(id);
			req.setAttribute("quote",one);
			/* req.getRequestDispatcher("give_reply.jsp").forward(req,res); */
			
			BEAN_QUOTE_FILE second = new BEAN_QUOTE_FILE();
			
			HttpSession ses = req.getSession(false);
			
			int tr_id=(Integer) ses.getAttribute("id");

			BEAN_LOG_FILE three = DAO_LOG_FILE.getUserById(tr_id);
			
			String uname=three.GET_TRANSPORTER_NAME();
			second.SET_TRANS_NAME(uname);
			BEAN_QUOTE_FILE four = new BEAN_QUOTE_FILE();
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "select * from trans_table where trans_email=? and is_join=1";
				
				PreparedStatement ps = cn.prepareStatement(query);
				System.out.println(uname);
				ps.setString(1,uname);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					four.SET_TRANS_ID(rs.getInt("trans_id"));
					req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Give Reply").forward(req,res);
				}
				else
				{
					four=null;
					res.setContentType("text/html");
				      PrintWriter pw = res.getWriter();
				      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
				      pw.println("<script>");
				      pw.println("function loa() \r\n" + 
				      		"{\r\n" + 
				      		"	swal(\"Opps!\", \"Please Pay The Join Amount!\", \"error\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Home\";\r\n" + 
				      		"	});\r\n" + 
				      		"}");
				      pw.println("</script>");
				      pw.println("<body  onload=\"loa()\"></body");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(act.equalsIgnoreCase("send"))
		{
				BEAN_QUOTE_FILE second = new BEAN_QUOTE_FILE();
					
				HttpSession ses = req.getSession(false);
				
				int tr_id=(Integer) ses.getAttribute("id");

				BEAN_LOG_FILE three = DAO_LOG_FILE.getUserById(tr_id);
				
				String uname=three.GET_TRANSPORTER_NAME();
				second.SET_TRANS_NAME(uname);
				
				
				BEAN_QUOTE_FILE one = new BEAN_QUOTE_FILE();
				try
				{
					Connection cn = CONNECT_FILE.sqlConnection();
					String query = "select * from trans_table where trans_email=? and is_join=1";
					
					PreparedStatement ps = cn.prepareStatement(query);
					System.out.println(uname);
					ps.setString(1,uname);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						one.SET_TRANS_ID(rs.getInt("trans_id"));
					}
					else
					{
						one=null;
						res.setContentType("text/html");
					      PrintWriter pw = res.getWriter();
					      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
					      pw.println("<script>");
					      pw.println("function loa() \r\n" + 
					      		"{\r\n" + 
					      		"	swal(\"Opps!\", \"You Entered Wrong Details!\", \"error\")\r\n" + 
					      		"	.then((value) => {\r\n" + 
					      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Home\";\r\n" + 
					      		"	});\r\n" + 
					      		"}");
					      pw.println("</script>");
					      pw.println("<body  onload=\"loa()\"></body");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
				int id = Integer.parseInt(req.getParameter("id"));
				try
				{
					Connection cn = CONNECT_FILE.sqlConnection();
					String query = "select * from send_req INNER JOIN cust_table ON (send_req.cust_id = cust_table.cust_id) INNER JOIN cat ON (send_req.category_id = cat.category_id) INNER JOIN sub_cat ON (send_req.sub_category_id = sub_cat.sub_category_id) INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id where quote_id=? and active_s=1";
					
					PreparedStatement ps = cn.prepareStatement(query);
					ps.setInt(1,id);
				
					ResultSet re = ps.executeQuery();
					if(re.next())
					{
						one.SET_QUOTE_ID(re.getInt("quote_id"));
						one.SET_USER_ID(re.getInt("cust_id"));
						one.SET_USER_NAME(re.getString("cust_email"));
						one.SET_CATEGORY_ID(re.getInt("category_id"));
						one.SET_CATEGORY_NAME(re.getString("category_name"));
						one.SET_SUB_CATEGORY_ID(re.getInt("sub_category_id"));
						one.SET_SUB_CATEGORY_NAME(re.getString("sub_category_name"));
						one.SET_SOURCE_ID(re.getInt("source_id"));
						one.SET_SOURCE_NAME(re.getString("source_name"));
						one.SET_DESTINATION_ID(re.getInt("destination_id"));
						one.SET_DESTINATION_NAME(re.getString("destination_name"));
						one.SET_MESSAGE(re.getString("description"));
						one.SET_FROM_DATE(re.getString("from_date"));
						one.SET_TO_DATE(re.getString("to_date"));
						one.SET_ADDRESS(re.getString("address"));
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
				second.SET_TRANS_ID(one.GET_TRANS_ID());
				second.SET_USER_ID(one.GET_USER_ID());
				second.SET_REPLY(req.getParameter("reply"));
				second.SET_QUOTE_ID(one.GET_QUOTE_ID());
				second.SET_CATEGORY_ID(one.GET_CATEGORY_ID());
				second.SET_SUB_CATEGORY_ID(one.GET_SUB_CATEGORY_ID());
				second.SET_SOURCE_ID(one.GET_SOURCE_ID());
				second.SET_DESTINATION_ID(one.GET_DESTINATION_ID());
				
				second.SET_USER_NAME(one.GET_USER_NAME());
				second.SET_CATEGORY_NAME(one.GET_CATEGORY_NAME());
				second.SET_SUB_CATEGORY_NAME(one.GET_SUB_CATEGORY_NAME());
				second.SET_SOURCE_NAME(one.GET_SOURCE_NAME());
				second.SET_DESTINATION_NAME(one.GET_DESTINATION_NAME());
				second.SET_FROM_DATE(one.GET_FROM_DATE());
				second.SET_TO_DATE(one.GET_TO_DATE());
				second.SET_MESSAGE(one.GET_MESSAGE());
				second.SET_ADDRESS(one.GET_ADDRESS());
				
				
				DAO_QUOTE_FILE two = new DAO_QUOTE_FILE();
				two.insertdata(second);
				
				
				res.setContentType("text/html;charset=UTF=8");
				try(PrintWriter out = res.getWriter())
				{
						String email = one.GET_USER_NAME();
							
							if(CONTROLLER_NOTIFICATION_FILE.GENERATE_Mail(email))
							{
								req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Replied Quote").forward(req,res);
							}
							else
							{
								res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Error");
							}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			/* req.getRequestDispatcher("reply_quote.jsp").forward(req,res); */
			
				
		}
		else if(act.equalsIgnoreCase("Delivered"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			int id1 = Integer.parseInt(req.getParameter("id1"));
			BEAN_ORDER_FILE one = new BEAN_ORDER_FILE();
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "update order_tab set delivered=1 where quote_id='"+id+"' and trans_id='"+id1+"'";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			String q = "select * from order_tab INNER JOIN send_req ON (order_tab.quote_id = send_req.quote_id) INNER JOIN send_reply ON (order_tab.trans_quote_id = send_reply.trans_quote_id) INNER JOIN cust_table ON (order_tab.cust_id = cust_table.cust_id) where send_req.quote_id='"+id+"'";
			BEAN_ORDER_FILE two = new BEAN_ORDER_FILE();
			
			res.setContentType("text/html;charset=UTF=8");
			try(PrintWriter out = res.getWriter())
			{
				Connection con = CONNECT_FILE.sqlConnection();
				PreparedStatement ps = con.prepareStatement(q);
				ResultSet re = ps.executeQuery();
				if(re.next())
				{
					two.SET_USER_NAME(re.getString("cust_email"));
					two.SET_MESSAGE(re.getString("description"));
					two.SET_REPLY(re.getString("reply"));
				}
					String email = two.GET_USER_NAME();
					String msg = two.GET_MESSAGE();
					String reply = two.GET_REPLY();
						
						if(CONTROLLER_NOTIFICATION_FILE.GENERATE_Mail_Delivery(email,msg,reply))
						{
							req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Home").forward(req,res);
						}
						else
						{
							res.sendRedirect("LOGIN_CONTROL_TRANSPORTER?page=Error");
						}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(act.equalsIgnoreCase("Dispatch"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			int id1 = Integer.parseInt(req.getParameter("id1"));
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "update order_tab set dispatch=1 where quote_id='"+id+"' and trans_id='"+id1+"'";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Home").forward(req,res);
		}
		else if(act.equalsIgnoreCase("Cancel"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			BEAN_ORDER_FILE one = new BEAN_ORDER_FILE();
			String reason= req.getParameter("reason");
			try
			{
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "SELECT * FROM order_tab INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON order_tab.category_id = cat.category_id INNER JOIN sub_cat ON order_tab.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_reply.source_id = source_table.source_id INNER JOIN destination_table ON send_reply.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id where send_req.quote_id=? and dispatch=0";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					one.SET_TRANS_QUOTE_ID(rs.getInt("trans_quote_id"));
					one.SET_QUOTE_ID(rs.getInt("quote_id"));
					one.SET_TRANS_ID(rs.getInt("trans_id"));
					one.SET_TRANS_NAME(rs.getString("trans_email"));
					one.SET_FIRST_NAME(rs.getString("first_name"));
					one.SET_USER_ID(rs.getInt("cust_id"));
					one.SET_USER_NAME(rs.getString("cust_email"));
					one.SET_LAST_NAME(rs.getString("last_name"));
					one.SET_CONTACT(rs.getString("contact"));
					one.SET_CATEGORY_ID(rs.getInt("category_id"));
					one.SET_CATEGORY_NAME(rs.getString("category_name"));
					one.SET_SUB_CATEGORY_ID(rs.getInt("sub_category_id"));
					one.SET_SUB_CATEGORY_NAME(rs.getString("sub_category_name"));
					one.SET_SOURCE_ID(rs.getInt("source_id"));
					one.SET_SOURCE_NAME(rs.getString("source_name"));
					one.SET_DESTINATION_ID(rs.getInt("destination_id"));
					one.SET_DESTINATION_NAME(rs.getString("destination_name"));
					one.SET_REPLY(rs.getString("reply"));
					one.SET_FROM_DATE(rs.getString("from_date"));
					one.SET_TO_DATE(rs.getString("to_date"));
					one.SET_MESSAGE(rs.getString("description"));
					one.SET_ADDRESS(rs.getString("address"));
					one.SET_ORDER_ID(rs.getInt("order_id"));
					one.SET_ORDER_DATE(rs.getString("date_of_order"));
					one.SET_REASON(reason);
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
			BEAN_ORDER_FILE second = new BEAN_ORDER_FILE();
			
			second.SET_TRANS_QUOTE_ID(one.GET_TRANS_QUOTE_ID());
			second.SET_TRANS_ID(one.GET_TRANS_ID());
			second.SET_USER_ID(one.GET_USER_ID());
			second.SET_REPLY(one.GET_REPLY());
			second.SET_QUOTE_ID(one.GET_QUOTE_ID());
			second.SET_CATEGORY_ID(one.GET_CATEGORY_ID());
			second.SET_SUB_CATEGORY_ID(one.GET_SUB_CATEGORY_ID());
			second.SET_SOURCE_ID(one.GET_SOURCE_ID());
			second.SET_DESTINATION_ID(one.GET_DESTINATION_ID());
			second.SET_TRANS_NAME(one.GET_TRANS_NAME());
			second.SET_ORDER_ID(one.GET_ORDER_ID());
			second.SET_USER_NAME(one.GET_USER_NAME());
			second.SET_CATEGORY_NAME(one.GET_CATEGORY_NAME());
			second.SET_SUB_CATEGORY_NAME(one.GET_SUB_CATEGORY_NAME());
			second.SET_SOURCE_NAME(one.GET_SOURCE_NAME());
			second.SET_DESTINATION_NAME(one.GET_DESTINATION_NAME());
			second.SET_FROM_DATE(one.GET_FROM_DATE());
			second.SET_TO_DATE(one.GET_TO_DATE());
			second.SET_MESSAGE(one.GET_MESSAGE());
			second.SET_FIRST_NAME(one.GET_FIRST_NAME());
			second.SET_LAST_NAME(one.GET_LAST_NAME());
			second.SET_CONTACT(one.GET_CONTACT()); 
			second.SET_ADDRESS(one.GET_ADDRESS());
			second.SET_ORDER_DATE(one.GET_ORDER_DATE());
			second.SET_REASON(one.GET_REASON());
			
			
			DAO_QUOTE_FILE two = new DAO_QUOTE_FILE();
			two.insertcanceldata(second);
			
			RequestDispatcher rd =  req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=View Cancled Orders");
			rd.include(req,res);
			
		}
		else if(act.equalsIgnoreCase("View"))
		{			
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_QUOTE_FILE d1 = new DAO_QUOTE_FILE();
			BEAN_ORDER_FILE one = d1.GET_BY_TRANS_QUOTE_ID(id);
			req.setAttribute("order_recipt",one);
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Order Receipt").forward(req,res);
		}
	}

}
