package COM.CUSTOMER.DAO;


import java.util.ArrayList;
import java.sql.*;
import COM.CUSTOMER.BEAN.TransporterModel;
import COM.CUSTOMER.CONNECT.CONNECT_FILE;

public class TransporterDAO {

	public ArrayList<TransporterModel> getAllTransporter(String pin) throws Exception{
		ArrayList<TransporterModel> transporters = new ArrayList<TransporterModel>();
		pin += "%";
		String sqlQuery = "SELECT * FROM`trans_table` WHERE pincode LIKE ?;";
		Connection connection = CONNECT_FILE.sqlConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, pin);
		ResultSet set = statement.executeQuery();
		
		while(set.next()) {
			TransporterModel transporter = new TransporterModel();
			transporter.setTransporterID(set.getInt("trans_id"));
			transporter.setTransFirstName(set.getString("first_name"));
			transporter.setTransLastName(set.getString("last_name"));
			transporter.setTransEmail(set.getString("trans_email"));
			transporter.setTransContact(set.getString("contact"));
			transporter.setTransPin(set.getString("pincode"));
			transporters.add(transporter);
		}
		
		return transporters;
	}
	
}

