package COM.CUSTOMER.CONTROLLER;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import COM.CUSTOMER.DAO.DAO_SUB_CATEGORY_FILE;

@WebServlet("/SUB_CATEGORY_ONE")
public class CONTROLLER_SUB_CATEGORY_FILE extends HttpServlet{
	

				/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

				public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
				{
					String act = req.getParameter("action");
					if(act.equalsIgnoreCase("submit"))
					{
						int id = Integer.parseInt(req.getParameter("id"));
						DAO_SUB_CATEGORY_FILE d1 = new DAO_SUB_CATEGORY_FILE();
						d1.DELETE_SUB_CATEGORY(id);
					}
				}
}
		
