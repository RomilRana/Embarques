package COM.TRANSPORTER.CONTROLLER;


import COM.TRANSPORTER.DAO.DAO_MAIL_NOTIFICATION;

public class CONTROLLER_NOTIFICATION_FILE {


	public static String otp;
	
	public static boolean GENERATE_Mail(String email)
	{
		if(email!=null)
		{
			DAO_MAIL_NOTIFICATION.sendMail(email,"Transporter Give Reply");
		
			return true;
		}
		return false;
	}
	
	public static boolean GENERATE_Mail_Order(String email)
	{
		if(email!=null)
		{
			DAO_MAIL_NOTIFICATION.sendMailOrder(email,"Customer Order");
		
			return true;
		}
		return false;
	}
	public static boolean GENERATE_Mail_Delivery(String email,String msg,String reply)
	{
		if(email!=null)
		{
			DAO_MAIL_NOTIFICATION.sendMailDelivery(email,msg,reply,"Order Delivered");
		
			return true;
		}
		return false;
	}
	
	public static boolean VERIFY_OTP(String email,String userotp)
	{
		if(otp.contentEquals(userotp))
		{
			return true;
		}
		return false;
		
	}
	
}
