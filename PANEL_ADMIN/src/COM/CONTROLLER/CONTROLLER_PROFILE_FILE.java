package COM.CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.BEAN.BEAN_PROFILE_FILE;
import COM.DAO.DAO_PROFILE;
@WebServlet("/PROFILE_ADMIN")
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
			req.getRequestDispatcher("UPDATE_PROFILE.jsp").forward(req,res);
		}	
		else if(act.equalsIgnoreCase("save"))
		{
			BEAN_PROFILE_FILE one = new BEAN_PROFILE_FILE();
			one.SET_USER_ID(Integer.parseInt(req.getParameter("id1")));
			one.SET_FIRST_NAME(req.getParameter("fname1"));
			one.SET_LAST_NAME(req.getParameter("lname1"));
			one.SET_CONTACT(Integer.parseInt(req.getParameter("contact1")));
			DAO_PROFILE d1 = new DAO_PROFILE();
			d1.UPDATE_FILE(one);
			req.getRequestDispatcher("PROFILE.jsp").forward(req,res);
		}
	}
}
