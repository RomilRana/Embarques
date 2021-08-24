package COM.CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.BEAN.BEAN_AREA_FILE;
import COM.DAO.DAO_AREA_FILE;

@WebServlet("/AREA_ONE")
public class CONTROLLER_AREA_FILE extends HttpServlet{


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
		{
			String act = req.getParameter("action");
			if(act.equalsIgnoreCase("submit"))
			{
				BEAN_AREA_FILE first = new BEAN_AREA_FILE();
				first.SET_AREA_ID(Integer.parseInt(req.getParameter("area_id")));
				

				BEAN_AREA_FILE second = new BEAN_AREA_FILE();
				second.SET_AREA_NAME(req.getParameter("area_name"));
				
				
				DAO_AREA_FILE one = new DAO_AREA_FILE();
				one.insertdata(first,second);
				
				req.getRequestDispatcher("SUCCESS_AREA.jsp").forward(req,res);
			}
			else if(act.equalsIgnoreCase("delete"))
			{
				int id = Integer.parseInt(req.getParameter("id"));
				DAO_AREA_FILE d1 = new DAO_AREA_FILE();
				d1.DELETE_AREA(id);
				req.getRequestDispatcher("SUCCESS_AREA.jsp").forward(req,res);
			}
			else if(act.equalsIgnoreCase("edit"))
			{
				int id = Integer.parseInt(req.getParameter("id"));
				DAO_AREA_FILE d1 = new DAO_AREA_FILE();
				BEAN_AREA_FILE one = d1.GET_BY_ID(id);
				req.setAttribute("area",one);
				req.getRequestDispatcher("UPDATE_AREA.jsp").forward(req,res);
			}
			else if(act.equalsIgnoreCase("save"))
			{
				BEAN_AREA_FILE one = new BEAN_AREA_FILE();
				one.SET_AREA_ID(Integer.parseInt(req.getParameter("id1")));
				one.SET_AREA_NAME(req.getParameter("name1"));
				DAO_AREA_FILE d1 = new DAO_AREA_FILE();
				d1.UPDATE_FILE(one);
				req.getRequestDispatcher("SUCCESS_AREA.jsp").forward(req,res);
			}
				
			}
				
	}


