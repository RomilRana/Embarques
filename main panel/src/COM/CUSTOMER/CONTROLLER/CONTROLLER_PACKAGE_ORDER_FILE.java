package COM.CUSTOMER.CONTROLLER;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import COM.CUSTOMER.CONNECT.CONNECT_FILE;
import COM.CUSTOMER.DAO.DAO_PACKAGE_FILE;
import COM.CUSTOMER.BEAN.BEAN_PACKAGE_FILE;

@WebServlet("/CUSTOMER/PACKAGE_ORDER_GSK")
public class CONTROLLER_PACKAGE_ORDER_FILE extends HttpServlet {


	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String act = req.getParameter("action");
		if (act.equalsIgnoreCase("Send")) {
			int id = Integer.parseInt(req.getParameter("id11"));
			HttpSession ses = req.getSession(false);
			int u_id = (Integer) ses.getAttribute("id");
			BEAN_PACKAGE_FILE eb = new BEAN_PACKAGE_FILE();
			try {
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "SELECT * FROM package where package_id=?";

				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					eb.SET_PACKAGE_ID(rs.getInt("package_id"));
					String add_1 = req.getParameter("add_1");
					String add_2 = req.getParameter("add_2");
					String add_3 = add_1 + " " + add_2;
					eb.SET_ADDRESS(add_3);
				} else {
					eb = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			BEAN_PACKAGE_FILE one = new BEAN_PACKAGE_FILE();

			one.SET_PACKAGE_ID(eb.GET_PACKAGE_ID());
			one.SET_FIRST_NAME(req.getParameter("first_name"));
			one.SET_LAST_NAME(req.getParameter("last_name"));
			one.SET_CONTACT(req.getParameter("contact"));
			one.SET_ADDRESS(eb.GET_ADDRESS());
			one.SET_USER_ID(u_id);

			DAO_PACKAGE_FILE two = new DAO_PACKAGE_FILE();
			two.insertdata(one);

			RequestDispatcher rd = req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Home");
			rd.include(req, res);

		}
	}
}
