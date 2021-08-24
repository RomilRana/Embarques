
package COM.CUSTOMER.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import COM.CUSTOMER.BEAN.BEAN_PACKAGE_FILE;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;
import COM.TRANSPORTER.BEAN.BEAN_PACKAGE_ORDER_FILE;

public class DAO_PACKAGE_FILE {

	public void insertdata(BEAN_PACKAGE_FILE b2) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		try {
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into package_booking(cust_id,first_name,last_name,address,contact,package_id,date_of_booking) values(?,?,?,?,?,?,'"+dtf.format(now)+"')";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(Query);

			
			ps.setInt(1, b2.GET_USER_ID());
			ps.setString(2, b2.GET_FIRST_NAME());
			ps.setString(3, b2.GET_LAST_NAME());
			ps.setString(4, b2.GET_ADDRESS());
			ps.setString(5, b2.GET_CONTACT());
			ps.setInt(6, b2.GET_PACKAGE_ID());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "update package set active_package=0 where package_id='" + b2.GET_PACKAGE_ID() + "'";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BEAN_PACKAGE_FILE> getAllInfo() throws SQLException {
		List<BEAN_PACKAGE_FILE> list = new ArrayList<BEAN_PACKAGE_FILE>();
		try {
			Connection con = CONNECT_FILE.sqlConnection();

			String query = "select * from package INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id where active_package=1";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();
			while (re.next()) {
				BEAN_PACKAGE_FILE eb = new BEAN_PACKAGE_FILE();
				eb.SET_PACKAGE_ID(re.getInt("package_id"));
				eb.SET_TRANSPORTER_ID(re.getInt("trans_id"));
				eb.SET_TRANSPORTER_NAME(re.getString("trans_email"));
				eb.SET_COMPANY_NAME(re.getString("company_name"));
				eb.SET_FROM_NAME(re.getString("source_name"));
				eb.SET_TO_NAME(re.getString("destination_name"));
				eb.SET_PACKAGE_PRICE(re.getInt("package_price"));
				eb.SET_PACKAGE_NAME(re.getString("package_title"));
				eb.SET_PACKAGE_DESCRIPTION(re.getString("package_description"));
				eb.SET_IMAGE_NAME(re.getString("image"));
				list.add(eb);
			}
			re.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BEAN_PACKAGE_ORDER_FILE> getAllInfo1(int id) throws SQLException {
		List<BEAN_PACKAGE_ORDER_FILE> list = new ArrayList<BEAN_PACKAGE_ORDER_FILE>();
		try {
			Connection con = CONNECT_FILE.sqlConnection();
			String query = "SELECT * FROM package_order INNER JOIN package ON package_order.package_id = package.package_id INNER JOIN package_booking ON package_order.package_booking_id = package_booking.package_booking_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id WHERE cust_table.cust_id='"+id+"' and cancel=0";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();

			while (re.next()) {
				BEAN_PACKAGE_ORDER_FILE eb = new BEAN_PACKAGE_ORDER_FILE();
				eb.SET_PACKAGE_BOOKING_ID(re.getInt("package_booking_id"));
				eb.SET_PACKAGE_ID(re.getInt("package_id"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_PACKAGE_PRICE(re.getInt("package_price"));
				eb.SET_PACKAGE_NAME(re.getString("package_title"));
				eb.SET_FROM_NAME(re.getString("source_name"));
				eb.SET_TO_NAME(re.getString("destination_name"));
				eb.SET_PACKAGE_DESCRIPTION(re.getString("package_description"));
				eb.SET_IMAGE_NAME(re.getString("image"));
				eb.SET_COMPANY(re.getString("company_name"));
				list.add(eb);
			}
			re.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BEAN_PACKAGE_FILE GET_BY_ID(int id) {
		BEAN_PACKAGE_FILE one = new BEAN_PACKAGE_FILE();
		try {
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "select * from package INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id where package_id=?";
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				one.SET_PACKAGE_ID(rs.getInt("package_id"));
				one.SET_TRANSPORTER_ID(rs.getInt("trans_id"));
				one.SET_TRANSPORTER_NAME(rs.getString("trans_email"));
				one.SET_COMPANY_NAME(rs.getString("company_name"));
				one.SET_FROM_NAME(rs.getString("source_name"));
				one.SET_TO_NAME(rs.getString("destination_name"));
				one.SET_PACKAGE_PRICE(rs.getInt("package_price"));
				one.SET_PACKAGE_NAME(rs.getString("package_title"));
				one.SET_PACKAGE_DESCRIPTION(rs.getString("package_description"));
				one.SET_IMAGE_NAME(rs.getString("image"));
			} else {
				one = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}

	public List<BEAN_PACKAGE_ORDER_FILE> getAllCancelInfo(int uid) throws SQLException {
		List<BEAN_PACKAGE_ORDER_FILE> list = new ArrayList<BEAN_PACKAGE_ORDER_FILE>();
		try {
			Connection con = CONNECT_FILE.sqlConnection();

			String query = "SELECT * FROM cancel_package_table INNER JOIN package ON cancel_package_table.package_id = package.package_id INNER JOIN package_booking ON cancel_package_table.package_booking_id = package_booking.package_booking_id INNER JOIN source_table ON package.source_id = source_table.source_id INNER JOIN destination_table ON package.destination_id = destination_table.destination_id  INNER JOIN cust_table ON package_booking.cust_id = cust_table.cust_id INNER JOIN trans_table ON package.trans_id = trans_table.trans_id INNER JOIN package_order ON cancel_package_table.order_id = package_order.order_id  WHERE cust_table.cust_id='"+ uid + "'";

			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);
			ResultSet re = ps.executeQuery();

			while (re.next()) {
				BEAN_PACKAGE_ORDER_FILE eb = new BEAN_PACKAGE_ORDER_FILE();
				eb.SET_PACKAGE_ORDER_ID(re.getInt("order_id"));
				eb.SET_PACKAGE_BOOKING_ID(re.getInt("package_booking_id"));
				eb.SET_PACKAGE_ID(re.getInt("package_id"));
				eb.SET_TRANSPORTER_ID(re.getInt("trans_id"));
				eb.SET_TRANSPORTER_NAME(re.getString("trans_email"));
				eb.SET_COMPANY_NAME(re.getString("company_name"));
				eb.SET_USER_ID(re.getInt("cust_id"));
				eb.SET_USER_NAME(re.getString("cust_email"));
				eb.SET_FROM_NAME(re.getString("source_name"));
				eb.SET_TO_NAME(re.getString("destination_name"));
				eb.SET_PACKAGE_NAME(re.getString("package_title"));
				eb.SET_PACKAGE_DESCRIPTION(re.getString("package_description"));
				eb.SET_PACKAGE_PRICE(Integer.parseInt(re.getString("package_price")));
				eb.SET_CANCEL_DATE(re.getString("cancel_date"));
				eb.SET_REASON(re.getString("reason"));
				eb.SET_CANCEL_BY(re.getString("cancel_by"));
				list.add(eb);
			}
			re.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertcancelpackagedata(BEAN_PACKAGE_ORDER_FILE b2) {
		int id = 0;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			Connection cn = CONNECT_FILE.sqlConnection();
			String Query = "insert into cancel_package_table(package_id,package_booking_id,cancel_date,reason,order_id) values(?,?,'"+dtf.format(now)+"',?,?)";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(Query);

			id = b2.GET_PACKAGE_BOOKING_ID();
			ps.setInt(1, b2.GET_PACKAGE_ID());
			ps.setInt(2, b2.GET_PACKAGE_BOOKING_ID());
			ps.setString(3, b2.GET_REASON());
			ps.setInt(4, b2.GET_PACKAGE_ORDER_ID());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection cn = CONNECT_FILE.sqlConnection();
			String query = "update package_order set cancel=1,cancel_by='Customer' where package_booking_id='"+id+ "'";
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
