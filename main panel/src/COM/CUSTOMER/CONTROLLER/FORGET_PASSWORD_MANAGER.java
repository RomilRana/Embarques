package COM.CUSTOMER.CONTROLLER;

import COM.CUSTOMER.DAO.DAO_MAIL_MANAGER_FILE;

public class FORGET_PASSWORD_MANAGER {

	public static String otp;
	
	public static boolean GENERATE_OTP(String email)
	{
		if(email!=null)
		{
			otp=DAO_MAIL_MANAGER_FILE.sendMail(email,"OTP");
			
			if(otp!=null)
			{
				return true;
			}
			else
			{
				return false;
			}
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
