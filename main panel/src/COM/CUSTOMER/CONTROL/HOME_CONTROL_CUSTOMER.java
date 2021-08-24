package COM.CUSTOMER.CONTROL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HOME_CONTROL_CUSTOMER
 */
@WebServlet("/CUSTOMER/HOME_CONTROL_CUSTOMER")
public class HOME_CONTROL_CUSTOMER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HOME_CONTROL_CUSTOMER() {
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
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(page.equals("Home"))
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(page.equals("About"))
		{
			request.getRequestDispatcher("about.jsp").forward(request, response);
		}
		else if(page.equals("Get Quote"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(page.equals("View Profile"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		else if(page.equals("Contact"))
		{
			request.getRequestDispatcher("contact.jsp").forward(request, response);
		}
		else if(page.equals("Register"))
		{
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else if(page.equals("Sign In"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
