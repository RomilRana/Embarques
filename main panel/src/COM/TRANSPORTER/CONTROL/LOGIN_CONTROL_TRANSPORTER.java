package COM.TRANSPORTER.CONTROL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LOGIN_CONTROL_TRANSPORTER
 */
@WebServlet("/TRANSPORTER/LOGIN_CONTROL_TRANSPORTER")
public class LOGIN_CONTROL_TRANSPORTER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LOGIN_CONTROL_TRANSPORTER() {
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
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(page.equals("Home"))
		{
			request.getRequestDispatcher("index_1.jsp").forward(request, response);
		}
		else if(page.equals("Login"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(page.equals("About"))
		{
			request.getRequestDispatcher("about_login.jsp").forward(request, response);
		}
		else if(page.equals("Reset Password"))
		{
			request.getRequestDispatcher("reset_password_file.jsp").forward(request, response);
		}
		else if(page.equals("Error"))
		{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		else if(page.equals("Password Otp"))
		{
			request.getRequestDispatcher("password_otp_file.jsp").forward(request, response);
		}
		else if(page.equals("Register Otp"))
		{
			request.getRequestDispatcher("register_otp_file.jsp").forward(request, response);
		}
		else if(page.equals("Forgot"))
		{
			request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
		}
		else if(page.equals("Send_Quote"))
		{
			request.getRequestDispatcher("send_quote.jsp").forward(request, response);
		}
		else if(page.equals("View Profile"))
		{
			request.getRequestDispatcher("view_profile.jsp").forward(request, response);
		}
		else if(page.equals("Update Profile"))
		{
			request.getRequestDispatcher("update_user.jsp").forward(request, response);
		}
		else if(page.equals("Replied Quote"))
		{
			request.getRequestDispatcher("reply_quote.jsp").forward(request, response);
		}
		else if(page.equals("Give Reply"))
		{
			request.getRequestDispatcher("give_reply.jsp").forward(request, response);
		}
		else if(page.equals("Add Package"))
		{
			request.getRequestDispatcher("add_package.jsp").forward(request, response);
		}
		else if(page.equals("Orders"))
		{
			request.getRequestDispatcher("view_orders.jsp").forward(request, response);
		}
		else if(page.equals("Notification"))
		{
			request.getRequestDispatcher("view_notification.jsp").forward(request, response);
		}
		else if(page.equals("Change Password"))
		{
			request.getRequestDispatcher("change_current_password.jsp").forward(request, response);
		}
		else if(page.equals("Contact"))
		{
			request.getRequestDispatcher("contact_login.jsp").forward(request, response);
		}
		else if(page.equals("View Package"))
		{
			request.getRequestDispatcher("view_package.jsp").forward(request, response);
		}
		else if(page.equals("View Package Order"))
		{
			request.getRequestDispatcher("view_package_order.jsp").forward(request, response);
		}
		else if(page.equals("View Package Request"))
		{
			request.getRequestDispatcher("view_package_request.jsp").forward(request, response);
		}
		else if(page.equals("View Cancel Orders"))
		{
			request.getRequestDispatcher("view_cancel_orders.jsp").forward(request, response);
		}
		else if(page.equals("View Cancel Package Orders"))
		{
			request.getRequestDispatcher("view_cancel_package_order.jsp").forward(request, response);
		}
		else if(page.equals("View Package Orders History"))
		{
			request.getRequestDispatcher("view_package_order_history.jsp").forward(request, response);
		}
		else if(page.equals("Login"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(page.equals("Update Package"))
		{
			request.getRequestDispatcher("update_package.jsp").forward(request, response);
		}
		else if(page.equals("Order History"))
		{
			request.getRequestDispatcher("view_order_history.jsp").forward(request, response);
		}
		else if(page.equals("Order Receipt"))
		{
			request.getRequestDispatcher("view_order_receipt.jsp").forward(request, response);
		}
		else if(page.equals("Feedback"))
		{
			request.getRequestDispatcher("feedback_file.jsp").forward(request, response);
		}
		else if(page.equals("Sign Out"))
		{
			request.getRequestDispatcher("signout.jsp").forward(request, response);
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
