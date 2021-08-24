package COM.CONTROLLER;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.BEAN.BEAN_USER_FILE;
import COM.DAO.DAO_USER_FILE;

@WebServlet("/USER_ONE")
public class CONTROLLER_USER_FILE extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		
		if(act.equalsIgnoreCase("delete"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			DAO_USER_FILE d1 = new DAO_USER_FILE();
			d1.DELETE_USER(id);
			req.getRequestDispatcher("view_user.jsp").forward(req,res);
		}
		
		
	}

}
