package COM.CUSTOMER.CONTROLLER;

import COM.CUSTOMER.DAO.DAO_MAIL_REGISTER;


public class REGISTER_MANAGER 
{
	

		public static String otp;
		public static String admin_mail="romilrana734@gmail.com";
		
		public static boolean GENERATE_OTP(String email)
		{
			if(email!=null)
			{
				otp=DAO_MAIL_REGISTER.sendMail(email,"OTP");
				
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
		public static boolean GENERATE_Register_Mail(String email,String fname,String lname)
		{
			if(email!=null)
			{
				DAO_MAIL_REGISTER.sendRegisterMail(email,fname,lname,"Registeration Successful");
				DAO_MAIL_REGISTER.sendAdminRegisterMail(admin_mail,fname,lname,"Registeration Successful");
			
				return true;
			}
			return false;
		}
		public static boolean VERIFY_OTP(String userotp)
		{
			if(otp.contentEquals(userotp))
			{
				return true;
			}
			return false;
			
		}
		
	}

