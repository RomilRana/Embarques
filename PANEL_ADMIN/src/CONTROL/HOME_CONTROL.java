package CONTROL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HOME_CONTROL
 */
@WebServlet("/HOME_CONTROL")
public class HOME_CONTROL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HOME_CONTROL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String page=request.getParameter("page");
		if(page==null)
		{
			request.getRequestDispatcher("INDEX.jsp").forward(request, response);
		}
		else if(page.equals("Dashboard"))
		{
			request.getRequestDispatcher("INDEX.jsp").forward(request, response);
		}
		else if(page.equals("Login"))
		{
			request.getRequestDispatcher("LOGIN.jsp").forward(request, response);
		}
		else if(page.equals("Logout"))
		{
			request.getRequestDispatcher("LOGIN.jsp").forward(request, response);
		}
		else if(page.equals("Add User"))
		{
			request.getRequestDispatcher("ADD_USER.jsp").forward(request, response);
		}
		else if(page.equals("Add Category"))
		{
			request.getRequestDispatcher("ADD_CATEGORY.jsp").forward(request, response);
		}
		else if(page.equals("Add Sub Category"))
		{
			request.getRequestDispatcher("ADD_SUB_CATEGORY.jsp").forward(request, response);
		}
		else if(page.equals("Add Area"))
		{
			request.getRequestDispatcher("ADD_AREA.jsp").forward(request, response);
		}
		else if(page.equals("Forget Password"))
		{
			request.getRequestDispatcher("FORGET.jsp").forward(request, response);
		}
		else if(page.equals("View Category"))
		{
			request.getRequestDispatcher("SUCCESS_CATEGORY.jsp").forward(request, response);
		}
		else if(page.equals("View Sub Category"))
		{
			request.getRequestDispatcher("SUCCESS_SUB_CATEGORY.jsp").forward(request, response);
		}
		else if(page.equals("View Area"))
		{
			request.getRequestDispatcher("SUCCESS_AREA.jsp").forward(request, response);
		}
		else if(page.equals("View Customer"))
		{
			request.getRequestDispatcher("SUCCESS_USER.jsp").forward(request, response);
		}
		else if(page.equals("View Transporter"))
		{
			request.getRequestDispatcher("view_transporter.jsp").forward(request, response);
		}
		else if(page.equals("View Unpaid Transporter"))
		{
			request.getRequestDispatcher("view_unpaid_transporter.jsp").forward(request, response);
		}
		else if(page.equals("View Profile"))
		{
			request.getRequestDispatcher("PROFILE.jsp").forward(request, response);
		}
		else if(page.equals("Feedback"))
		{
			request.getRequestDispatcher("view_feedback.jsp").forward(request, response);
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
