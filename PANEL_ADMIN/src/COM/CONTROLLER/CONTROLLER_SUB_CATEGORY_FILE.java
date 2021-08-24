package COM.CONTROLLER;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.BEAN.BEAN_CATEGORY_FILE;
import COM.BEAN.BEAN_SUB_CATEGORY_FILE;
import COM.DAO.DAO_CATEGORY_FILE;
import COM.DAO.DAO_SUB_CATEGORY_FILE;

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
						BEAN_SUB_CATEGORY_FILE second = new BEAN_SUB_CATEGORY_FILE();
						second.SET_SUB_CATEGORY_NAME(req.getParameter("sub_category_name"));
						second.SET_CATEGORY_ID(Integer.parseInt(req.getParameter("category_id")));
						
						DAO_SUB_CATEGORY_FILE one = new DAO_SUB_CATEGORY_FILE();
						one.insertdata(second);
						
						req.getRequestDispatcher("SUCCESS_SUB_CATEGORY.jsp").forward(req,res);
					}
					else if(act.equalsIgnoreCase("delete"))
					{
						int id = Integer.parseInt(req.getParameter("id"));
						DAO_SUB_CATEGORY_FILE d1 = new DAO_SUB_CATEGORY_FILE();
						d1.DELETE_SUB_CATEGORY(id);
						req.getRequestDispatcher("SUCCESS_SUB_CATEGORY.jsp").forward(req,res);
					}
					else if(act.equalsIgnoreCase("edit"))
					{
						int id = Integer.parseInt(req.getParameter("id"));
						DAO_SUB_CATEGORY_FILE d1 = new DAO_SUB_CATEGORY_FILE();
						BEAN_SUB_CATEGORY_FILE one = d1.GET_BY_ID(id);
						req.setAttribute("sub_category",one);
						req.getRequestDispatcher("UPDATE_SUB_CATEGORY.jsp").forward(req,res);
					}				
					else if(act.equalsIgnoreCase("save"))
					{
						BEAN_SUB_CATEGORY_FILE one = new BEAN_SUB_CATEGORY_FILE();
						one.SET_SUB_CATEGORY_ID(Integer.parseInt(req.getParameter("id")));
						one.SET_SUB_CATEGORY_NAME(req.getParameter("name1"));
						DAO_SUB_CATEGORY_FILE d1 = new DAO_SUB_CATEGORY_FILE();
						d1.UPDATE_FILE(one);
						req.getRequestDispatcher("SUCCESS_SUB_CATEGORY.jsp").forward(req,res);
					}
				}
}
		
