package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.CUSTOMER.BEAN.TransporterModel;
import COM.CUSTOMER.DAO.TransporterDAO;

/**
 * Servlet implementation class TransporterSearchController1
 */
@WebServlet("/CUSTOMER/TransporterSearchController1")
public class TransporterSearchController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransporterSearchController1() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("action");
		if(act.equalsIgnoreCase("GO"))
		{
			response.getWriter().print(request.getParameter("pincode"));
			TransporterDAO transporterDAO = new TransporterDAO();
			try {
				ArrayList<TransporterModel> trans = transporterDAO.getAllTransporter(request.getParameter("pincode"));
				HttpSession session = request.getSession();
				session.setAttribute("transporter", trans);
				System.out.println(trans.get(0).getTransporterID());
				/* response.sendRedirect("search_t.jsp"); */
				 response.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Search"); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	}


