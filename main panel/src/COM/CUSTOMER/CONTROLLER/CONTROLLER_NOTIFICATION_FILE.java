package COM.CUSTOMER.CONTROLLER;


import COM.CUSTOMER.DAO.DAO_MAIL_NOTIFICATION;

public class CONTROLLER_NOTIFICATION_FILE {


	public static String otp;
	
	public static boolean GENERATE_Mail(String email,String fname,String lname)
	{
		if(email!=null)
		{
			DAO_MAIL_NOTIFICATION.sendMail(email,fname,lname,"Customer send Requirements");
		
			return true;
		}
		return false;
	}
	
	public static boolean GENERATE_Mail_Order_Both(String email,String cust_email,String add,String date,String reply)
	{
		if(email!=null)
		{
			DAO_MAIL_NOTIFICATION.sendMailOrderTransporter(email,add,date,reply,"Customer Order");
			DAO_MAIL_NOTIFICATION.sendMailOrderCustomer(cust_email,add,date,reply,"Customer Order");
			return true;
		}
		return false;
	}
	public static boolean GENERATE_Mail_Order_Customer(String email,String add,String date,String reply)
	{
		if(email!=null)
		{
			DAO_MAIL_NOTIFICATION.sendMailOrderCustomer(email,add,date,reply,"Customer Order");
		
			return true;
		}
		return false;
	}
	/*
	 * public static boolean GENERATE_Mail_Package_Order(String email,String
	 * add,String date,String reply) { if(email!=null) {
	 * DAO_MAIL_NOTIFICATION.sendMailPackageOrderCustomer(email,add,date,
	 * reply,"Customer Package Order");
	 * 
	 * return true; } return false; }
	 */
	
	public static boolean VERIFY_OTP(String email,String userotp)
	{
		if(otp.contentEquals(userotp))
		{
			return true;
		}
		return false;
		
	}
	
}
