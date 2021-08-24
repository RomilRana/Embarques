package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.TRANSPORTER.BEAN.BEAN_PROFILE_FILE;
import COM.TRANSPORTER.DAO.DAO_PROFILE;

/**
 * Servlet implementation class ViewTransporterController
 */
@WebServlet("/CUSTOMER/ViewTransporterController")
public class ViewTransporterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewTransporterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("trans_id"));
		System.out.print(id);
		DAO_PROFILE d1 = new DAO_PROFILE();
		BEAN_PROFILE_FILE one = d1.GET_BY_UID(id);
		request.setAttribute("specificTranspoter",one);
		RequestDispatcher dispatch = request.getRequestDispatcher("/CUSTOMER/viewTransporter.jsp");
		dispatch.forward(request, response);
	}

}
