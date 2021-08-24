package COM.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.BEAN.BEAN_CATEGORY_FILE;
import COM.CONNECT.CONNECT_FILE;
import COM.DAO.DAO_CATEGORY_FILE;

@WebServlet("/CATEGORY_ONE")
public class CONTROLLER_CATEGORY_FILE extends HttpServlet{

	

			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
			{
				String act = req.getParameter("action");
				if(act.equalsIgnoreCase("submit"))
				{
					/*BEAN_CATEGORY_FILE first = new BEAN_CATEGORY_FILE();
					first.SET_CATEGORY_ID(Integer.parseInt(req.getParameter("category_id")));
					*/
					BEAN_CATEGORY_FILE second = new BEAN_CATEGORY_FILE();
					second.SET_CATEGORY_NAME(req.getParameter("category_name"));
					
					
					DAO_CATEGORY_FILE one = new DAO_CATEGORY_FILE();
					one.insertdata(second);
					
					req.getRequestDispatcher("SUCCESS_CATEGORY.jsp").forward(req,res);
                    
				}
				else if(act.equalsIgnoreCase("delete"))
				{
					int id = Integer.parseInt(req.getParameter("id"));
					DAO_CATEGORY_FILE d1 = new DAO_CATEGORY_FILE();
					Connection cn =CONNECT_FILE.sqlConnection();
					String str="select * from sub_cat where category_id='"+id+"'";
					try
					{
					PreparedStatement pst = cn.prepareStatement(str);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						res.setContentType("text/html");
					      PrintWriter pw = res.getWriter();
					      pw.println("<script src=\"RESOURCES/sweetalert.min.js\"></script>");
					      pw.println("<script>");
					      pw.println("function loa() \r\n" + 
					      		"{\r\n" + 
					      		"	swal(\"ERROR\", \"You Can not Delete This Category Because SubCategory Exist For This Category\", \"error\")\r\n" + 
					      		"	.then((value) => {\r\n" + 
					      		"		window.location.href = \"HOME_CONTROL?page=View Category\";\r\n" + 
					      		"	});\r\n" + 
					      		"}");
					      pw.println("</script>");
					      pw.println("<body  onload=\"loa()\"></body");
					}
					else
					{
						d1.DELETE_AREA(id);
						req.getRequestDispatcher("SUCCESS_CATEGORY.jsp").forward(req,res);
					}
					}
					catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				else if(act.equalsIgnoreCase("edit"))
				{
					int id = Integer.parseInt(req.getParameter("id"));
					DAO_CATEGORY_FILE d1 = new DAO_CATEGORY_FILE();
					BEAN_CATEGORY_FILE one = d1.GET_BY_ID(id);
					req.setAttribute("category",one);
					req.getRequestDispatcher("UPDATE_CATEGORY.jsp").forward(req,res);
				}				
				else if(act.equalsIgnoreCase("save"))
				{
					BEAN_CATEGORY_FILE one = new BEAN_CATEGORY_FILE();
					one.SET_CATEGORY_ID(Integer.parseInt(req.getParameter("id1")));
					one.SET_CATEGORY_NAME(req.getParameter("name1"));
					DAO_CATEGORY_FILE d1 = new DAO_CATEGORY_FILE();
					d1.UPDATE_FILE(one);
					req.getRequestDispatcher("SUCCESS_CATEGORY.jsp").forward(req,res);
				}	
				
				}
					
		}


