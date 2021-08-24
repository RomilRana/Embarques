package COM.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import COM.BEAN.BEAN_LOG_FILE;
import COM.DAO.DAO_LOG_FILE;

@WebServlet("/ADMIN_LOG")
public class CONTROLLER_LOG_USER_FILE extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		/*
		 * String act = req.getParameter("action"); if(act.equalsIgnoreCase("submit")) {
		 * String em = req.getParameter("admin_email"); String pass =
		 * req.getParameter("admin_password");
		 * 
		 * HttpSession ses = req.getSession(); String uname =
		 * req.getParameter("admin_email"); ses.setAttribute("email_a",uname); try {
		 * Connection cn = CONNECT_FILE.sqlConnection(); String Query =
		 * "select * from admin_log where admin_email=? and admin_password=?";
		 * 
		 * PreparedStatement ps =(PreparedStatement) cn.prepareStatement(Query);
		 * 
		 * ps.setString(1,em); ps.setString(2,pass); ResultSet rs = ps.executeQuery();
		 * if(rs.next()) { req.getRequestDispatcher("INDEX.jsp").forward(req,res); }
		 * else { req.getRequestDispatcher("login_one.jsp").forward(req,res); } }
		 * catch(Exception ex) { ex.printStackTrace(); } }
		 */
		
		String action=req.getParameter("action");
		String email = req.getParameter("admin_email");
		String pass = req.getParameter("admin_password");
		
		int id=0;
		boolean status = DAO_LOG_FILE.isValidAdmin(email, pass);
		try
		{
			id=DAO_LOG_FILE.getIdByEmail(email);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		BEAN_LOG_FILE rb = DAO_LOG_FILE.getAdminById(id);
		
		if(action.equalsIgnoreCase("submit"))
		{
			if(status)
			{
				HttpSession session = req.getSession();
				session.setAttribute("id", rb.GET_ADMIN_ID());
				
				/* res.sendRedirect("index_1.jsp"); */
						res.setContentType("text/html");
				      PrintWriter pw = res.getWriter();
				      pw.println("<script src=\"RESOURCES/sweetalert.min.js\"></script>");
				      pw.println("<script>");
				      pw.println("function loa() \r\n" + 
				      		"{\r\n" + 
				      		"	swal(\"Success!\", \"Welcome  "+email+"\", \"success\")\r\n" + 
				      		"	.then((value) => {\r\n" + 
				      		"		window.location.href = \"HOME_CONTROL?page=Dashboard\";\r\n" + 
				      		"	});\r\n" + 
				      		"}");
				      pw.println("</script>");
				      pw.println("<body  onload=\"loa()\"></body");
			}
			else
			{	res.setContentType("text/html");
		      PrintWriter pw = res.getWriter();
		      pw.println("<script src=\"RESOURCES/sweetalert.min.js\"></script>");
		      pw.println("<script>");
		      pw.println("function loa() \r\n" + 
		      		"{\r\n" + 
		      		"	swal(\"Opps!\", \"You Entered Wrong Details!\", \"error\")\r\n" + 
		      		"	.then((value) => {\r\n" + 
		      		"		window.location.href = \"HOME_CONTROL?page=Login\";\r\n" + 
		      		"	});\r\n" + 
		      		"}");
		      pw.println("</script>");
		      pw.println("<body  onload=\"loa()\"></body");
			}
		}
		else
		{
			res.sendRedirect("login.jsp?msg=Email or Password Wrong...!");
		}
		
	}

}
