package COM.CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.DAO.DAO_TRANSPORTER_FILE;

@WebServlet("/TRANS_ONE")
public class CONTROLLER_TRANSPORTER_FILE extends HttpServlet {
	
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
			DAO_TRANSPORTER_FILE d1 = new DAO_TRANSPORTER_FILE();
			d1.DELETE_USER(id);
			req.getRequestDispatcher("view_transporter.jsp").forward(req,res);
		}
		else if(act.equalsIgnoreCase("paid"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			DAO_TRANSPORTER_FILE d1 = new DAO_TRANSPORTER_FILE();
			d1.PAID_USER(id);
			req.getRequestDispatcher("view_transporter.jsp").forward(req,res);
		}
	}

}
