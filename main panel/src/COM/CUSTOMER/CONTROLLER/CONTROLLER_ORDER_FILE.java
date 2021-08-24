
package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
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

import COM.CUSTOMER.BEAN.BEAN_ORDER_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;
import COM.CUSTOMER.DAO.DAO_ORDER_FILE;
import COM.CUSTOMER.DAO.DAO_PACKAGE_FILE;
import COM.TRANSPORTER.BEAN.BEAN_PACKAGE_ORDER_FILE;
import COM.CUSTOMER.BEAN.BEAN_PACKAGE_FILE;

@WebServlet("/CUSTOMER/ORDER_ONE")
public class CONTROLLER_ORDER_FILE extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String act = req.getParameter("action");
		if (act.equalsIgnoreCase("CONFIRM")) {
			int id = Integer.parseInt(req.getParameter("id11"));

			HttpSession ses = req.getSession(false);
			int u_id = (Integer) ses.getAttribute("id");

			BEAN_ORDER_FILE one = new BEAN_ORDER_FILE();
			try {
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "SELECT * FROM send_reply INNER JOIN trans_table ON send_reply.trans_id = trans_table.trans_id INNER JOIN send_req ON send_reply.quote_id = send_req.quote_id  INNER JOIN cust_table ON send_req.cust_id = cust_table.cust_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id where send_req.quote_id=?";

				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					one.SET_TRANS_QUOTE_ID(rs.getInt("trans_quote_id"));
					one.SET_QUOTE_ID(rs.getInt("quote_id"));
					one.SET_TRANS_ID(rs.getInt("trans_id"));
					one.SET_TRANS_NAME(rs.getString("trans_email"));
					one.SET_COMPANY_NAME(rs.getString("company_name"));
					one.SET_FIRST_NAME(rs.getString("first_name"));
					one.SET_USER_NAME(rs.getString("cust_email"));
					one.SET_LAST_NAME(rs.getString("last_name"));
					one.SET_CONTACT(rs.getString("contact"));
					one.SET_CATEGORY_ID(rs.getInt("category_id"));
					one.SET_CATEGORY_NAME(rs.getString("category_name"));
					one.SET_SUB_CATEGORY_ID(rs.getInt("sub_category_id"));
					one.SET_SUB_CATEGORY_NAME(rs.getString("sub_category_name"));
					one.SET_SOURCE_ID(rs.getInt("source_id"));
					one.SET_SOURCE_NAME(rs.getString("source_name"));
					one.SET_DESTINATION_ID(rs.getInt("destination_id"));
					one.SET_DESTINATION_NAME(rs.getString("destination_name"));
					one.SET_REPLY(rs.getString("reply"));
					one.SET_FROM_DATE(rs.getString("from_date"));
					one.SET_TO_DATE(rs.getString("to_date"));
					one.SET_MESSAGE(rs.getString("description"));
					one.SET_ADDRESS(rs.getString("address"));
				} else {
					one = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			BEAN_ORDER_FILE second = new BEAN_ORDER_FILE();

			second.SET_TRANS_QUOTE_ID(one.GET_TRANS_QUOTE_ID());
			second.SET_TRANS_ID(one.GET_TRANS_ID());
			second.SET_USER_ID(u_id);
			second.SET_REPLY(one.GET_REPLY());
			second.SET_QUOTE_ID(one.GET_QUOTE_ID());
			second.SET_CATEGORY_ID(one.GET_CATEGORY_ID());
			second.SET_SUB_CATEGORY_ID(one.GET_SUB_CATEGORY_ID());
			second.SET_SOURCE_ID(one.GET_SOURCE_ID());
			second.SET_DESTINATION_ID(one.GET_DESTINATION_ID());
			second.SET_TRANS_NAME(one.GET_TRANS_NAME());
			second.SET_COMPANY_NAME(one.GET_COMPANY_NAME());

			second.SET_USER_NAME(one.GET_USER_NAME());
			second.SET_CATEGORY_NAME(one.GET_CATEGORY_NAME());
			second.SET_SUB_CATEGORY_NAME(one.GET_SUB_CATEGORY_NAME());
			second.SET_SOURCE_NAME(one.GET_SOURCE_NAME());
			second.SET_DESTINATION_NAME(one.GET_DESTINATION_NAME());
			second.SET_FROM_DATE(one.GET_FROM_DATE());
			second.SET_TO_DATE(one.GET_TO_DATE());
			second.SET_MESSAGE(one.GET_MESSAGE());
			second.SET_FIRST_NAME(req.getParameter("first_name"));
			second.SET_LAST_NAME(req.getParameter("last_name"));
			second.SET_CONTACT(req.getParameter("contact"));
			second.SET_ADDRESS(one.GET_ADDRESS());

			DAO_ORDER_FILE two = new DAO_ORDER_FILE();
			two.insertdata(second);

			res.setContentType("text/html;charset=UTF=8");
			try (PrintWriter out = res.getWriter()) {

				String email = one.GET_TRANS_NAME();
				String email_cust = one.GET_USER_NAME();
				String add = second.GET_ADDRESS();
				String date = one.GET_TO_DATE();
				String reply = one.GET_REPLY();

				if (CONTROLLER_NOTIFICATION_FILE.GENERATE_Mail_Order_Both(email, email_cust, add, date, reply)) {

					RequestDispatcher rd = req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Home");
					rd.include(req, res);

				}

				else {
					res.sendRedirect("LOGIN_CONTROL_CUSTOMER?page=Error");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (act.equalsIgnoreCase("View")) {
			int id = Integer.parseInt(req.getParameter("id11"));
			DAO_ORDER_FILE d1 = new DAO_ORDER_FILE();
			BEAN_ORDER_FILE one = d1.GET_BY_TRANS_QUOTE_ID(id);
			req.setAttribute("order_recipt", one);
			req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=Order Receipt").forward(req, res);
		} else if (act.equalsIgnoreCase("cancel")) {
			int id = Integer.parseInt(req.getParameter("id"));
			BEAN_ORDER_FILE one = new BEAN_ORDER_FILE();
			String reason = req.getParameter("reason");
			try {
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "SELECT * FROM order_tab INNER JOIN send_req ON order_tab.quote_id = send_req.quote_id INNER JOIN send_reply ON order_tab.trans_quote_id = send_reply.trans_quote_id INNER JOIN trans_table ON order_tab.trans_id = trans_table.trans_id INNER JOIN cat ON send_req.category_id = cat.category_id INNER JOIN sub_cat ON send_req.sub_category_id = sub_cat.sub_category_id  INNER JOIN source_table ON send_req.source_id = source_table.source_id INNER JOIN destination_table ON send_req.destination_id = destination_table.destination_id INNER JOIN cust_table ON order_tab.cust_id = cust_table.cust_id  where send_req.quote_id=? and dispatch=0";

				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					one.SET_TRANS_QUOTE_ID(rs.getInt("trans_quote_id"));
					one.SET_QUOTE_ID(rs.getInt("quote_id"));
					one.SET_TRANS_ID(rs.getInt("trans_id"));
					one.SET_TRANS_NAME(rs.getString("trans_email"));
					one.SET_COMPANY_NAME(rs.getString("company_name"));
					one.SET_FIRST_NAME(rs.getString("first_name"));
					one.SET_USER_ID(rs.getInt("cust_id"));
					one.SET_USER_NAME(rs.getString("cust_email"));
					one.SET_LAST_NAME(rs.getString("last_name"));
					one.SET_CONTACT(rs.getString("contact"));
					one.SET_CATEGORY_ID(rs.getInt("category_id"));
					one.SET_CATEGORY_NAME(rs.getString("category_name"));
					one.SET_SUB_CATEGORY_ID(rs.getInt("sub_category_id"));
					one.SET_SUB_CATEGORY_NAME(rs.getString("sub_category_name"));
					one.SET_SOURCE_ID(rs.getInt("source_id"));
					one.SET_SOURCE_NAME(rs.getString("source_name"));
					one.SET_DESTINATION_ID(rs.getInt("destination_id"));
					one.SET_DESTINATION_NAME(rs.getString("destination_name"));
					one.SET_REPLY(rs.getString("reply"));
					one.SET_FROM_DATE(rs.getString("from_date"));
					one.SET_TO_DATE(rs.getString("to_date"));
					one.SET_MESSAGE(rs.getString("description"));
					one.SET_ADDRESS(rs.getString("address"));
					one.SET_ORDER_ID(rs.getInt("order_id"));
					one.SET_ORDER_DATE(rs.getString("date_of_order"));
					one.SET_REASON(reason);
				} else {
					one = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			BEAN_ORDER_FILE second = new BEAN_ORDER_FILE();

			second.SET_TRANS_QUOTE_ID(one.GET_TRANS_QUOTE_ID());
			second.SET_TRANS_ID(one.GET_TRANS_ID());
			second.SET_USER_ID(one.GET_USER_ID());
			second.SET_REPLY(one.GET_REPLY());
			second.SET_QUOTE_ID(one.GET_QUOTE_ID());
			second.SET_CATEGORY_ID(one.GET_CATEGORY_ID());
			second.SET_SUB_CATEGORY_ID(one.GET_SUB_CATEGORY_ID());
			second.SET_SOURCE_ID(one.GET_SOURCE_ID());
			second.SET_DESTINATION_ID(one.GET_DESTINATION_ID());
			second.SET_TRANS_NAME(one.GET_TRANS_NAME());
			second.SET_ORDER_ID(one.GET_ORDER_ID());
			second.SET_USER_NAME(one.GET_USER_NAME());
			second.SET_CATEGORY_NAME(one.GET_CATEGORY_NAME());
			second.SET_SUB_CATEGORY_NAME(one.GET_SUB_CATEGORY_NAME());
			second.SET_SOURCE_NAME(one.GET_SOURCE_NAME());
			second.SET_DESTINATION_NAME(one.GET_DESTINATION_NAME());
			second.SET_FROM_DATE(one.GET_FROM_DATE());
			second.SET_TO_DATE(one.GET_TO_DATE());
			second.SET_MESSAGE(one.GET_MESSAGE());
			second.SET_FIRST_NAME(one.GET_FIRST_NAME());
			second.SET_LAST_NAME(one.GET_LAST_NAME());
			second.SET_CONTACT(one.GET_CONTACT());
			second.SET_ADDRESS(one.GET_ADDRESS());
			second.SET_ORDER_DATE(one.GET_ORDER_DATE());
			second.SET_REASON(one.GET_REASON());
			second.SET_COMPANY_NAME(one.GET_COMPANY_NAME());

			DAO_ORDER_FILE two = new DAO_ORDER_FILE();
			two.insertcanceldata(second);

			RequestDispatcher rd = req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders");
			rd.include(req, res);

		} else if (act.equalsIgnoreCase("cancel-package")) {
			int id = Integer.parseInt(req.getParameter("id"));
			BEAN_PACKAGE_ORDER_FILE eb = new BEAN_PACKAGE_ORDER_FILE();
			String reason = req.getParameter("reason");
			try {
				Connection cn = CONNECT_FILE.sqlConnection();
				String query = "SELECT * FROM package_order INNER JOIN package ON package_order.package_id = package.package_id INNER JOIN package_booking ON package_order.package_booking_id = package_booking.package_booking_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id WHERE package_booking.package_booking_id=? AND dispatch=0";

				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					eb.SET_PACKAGE_BOOKING_ID(rs.getInt("package_booking_id"));
					eb.SET_PACKAGE_ORDER_ID(rs.getInt("order_id"));
					eb.SET_PACKAGE_ID(rs.getInt("package_id"));
					eb.SET_USER_ID(rs.getInt("cust_id"));
					eb.SET_TRANSPORTER_ID(rs.getInt("trans_id"));
					eb.SET_USER_NAME(rs.getString("cust_email"));
					eb.SET_PACKAGE_PRICE(rs.getInt("package_price"));
					eb.SET_PACKAGE_NAME(rs.getString("package_title"));
					eb.SET_FROM_NAME(rs.getString("source_name"));
					eb.SET_TO_NAME(rs.getString("destination_name"));
					eb.SET_PACKAGE_DESCRIPTION(rs.getString("package_description"));
					eb.SET_IMAGE_NAME(rs.getString("image"));
					eb.SET_FIRST_NAME(rs.getString("first_name"));
					eb.SET_LAST_NAME(rs.getString("last_name"));
					eb.SET_ADDRESS(rs.getString("address"));
					eb.SET_CONTACT(rs.getString("contact"));
					eb.SET_REASON(reason);
					eb.SET_CANCEL_BY("customer");
				} else {
					eb = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			DAO_PACKAGE_FILE two = new DAO_PACKAGE_FILE();
			two.insertcancelpackagedata(eb);

			RequestDispatcher rd = req.getRequestDispatcher("LOGIN_CONTROL_CUSTOMER?page=View Cancled Orders");
			rd.include(req, res);

		}
	}
}
