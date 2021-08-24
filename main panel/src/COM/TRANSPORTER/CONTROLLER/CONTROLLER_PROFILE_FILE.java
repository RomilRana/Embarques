package COM.TRANSPORTER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.TRANSPORTER.BEAN.BEAN_LOG_FILE;
import COM.TRANSPORTER.BEAN.BEAN_PROFILE_FILE;
import COM.TRANSPORTER.BEAN.BEAN_QUOTE_FILE;
import COM.TRANSPORTER.CONNECT.CONNECT_FILE;
import COM.TRANSPORTER.DAO.DAO_LOG_FILE;
import COM.TRANSPORTER.DAO.DAO_PROFILE;
@WebServlet("/TRANSPORTER/PROFILE_ONE")
public class CONTROLLER_PROFILE_FILE extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("edit"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			DAO_PROFILE d1 = new DAO_PROFILE();
			BEAN_PROFILE_FILE one = d1.GET_BY_UID(id);
			req.setAttribute("user_fun",one);
			/* req.getRequestDispatcher("update_user.jsp").forward(req,res); */
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Update Profile").forward(req,res);
			
		
		}	
		else if(act.equalsIgnoreCase("save"))
		{
			BEAN_PROFILE_FILE one = new BEAN_PROFILE_FILE();
			one.SET_USER_ID(Integer.parseInt(req.getParameter("id1")));
			one.SET_FIRST_NAME(req.getParameter("fname1"));
			one.SET_LAST_NAME(req.getParameter("lname1"));
			one.SET_CONTACT(req.getParameter("contact1"));
			DAO_PROFILE d1 = new DAO_PROFILE();
			d1.UPDATE_FILE(one);
			/* req.getRequestDispatcher("view_profile.jsp").forward(req,res); */
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=View Profile").forward(req,res);
		}
		else if(act.equalsIgnoreCase("Change"))
		{
			
			BEAN_LOG_FILE two = null;
			BEAN_PROFILE_FILE one = new BEAN_PROFILE_FILE();
			Cookie[] hi = req.getCookies();
			String uname="";
			
			if(hi!=null)
			{
				for(Cookie hello : hi)
				{
					if(hello.getName().equals("email"))
					{
						uname=hello.getValue();
					}
				}
			}
			int id;
			
			
			String check = null;
			String curr_pass=req.getParameter("current_password");
			try
			{
				id=DAO_LOG_FILE.getIdByEmail(uname);
				
				two = DAO_LOG_FILE.getUserById(id);
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "select * from trans_table where trans_email=?";
				
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1,uname);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					check=two.GET_TRANSPORTER_PASSWORD();
					two.SET_TRANSPORTER_ID(rs.getInt("trans_id"));
				}
			}
			catch(Exception e)
			{	
				e.printStackTrace();
			}
			if(check.contains(curr_pass))
			{
			one.SET_USER_PASSWORD(req.getParameter("new_password"));
			one.SET_USER_ID(two.GET_TRANSPORTER_ID());
			DAO_PROFILE d1 = new DAO_PROFILE();
			d1.UPDATE_PASSWORD_FILE(one);
			/* req.getRequestDispatcher("view_profile.jsp").forward(req,res); */
			req.getRequestDispatcher("LOGIN_CONTROL_TRANSPORTER?page=Login").forward(req,res);
			}
			else
			{
					res.setContentType("text/html");
			      PrintWriter pw = res.getWriter();
			      pw.println("<script src=\"resources/sweetalert.min.js\"></script>");
			      pw.println("<script>");
			      pw.println("function loa() \r\n" + 
			      		"{\r\n" + 
			      		"	swal(\"Error!\", \"CURRENT PASSWORD IS NOT MATCHED!\", \"error\")\r\n" + 
			      		"	.then((value) => {\r\n" + 
			      		"		window.location.href = \"LOGIN_CONTROL_TRANSPORTER?page=Change Password\";\r\n" + 
			      		"	});\r\n" + 
			      		"}");
			      pw.println("</script>");
			      pw.println("<body  onload=\"loa()\"></body");
			}
			
	}
	}
}
