package COM.TRANSPORTER.DAO;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class DAO_MAIL_NOTIFICATION {


	
	private final static String fromMail="embaques123321@gmail.com"; 
	private final static String pass="123embarques321";
	
	static char[] OTP(int len)
	{
		String numbers="01234679";
		
		Random rndm_method = new Random();
		
		char[] otp = new char[len];
		
		for(int i=0;i<len;i++)
		{
			otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}
	
	public static String sendMail(String to,String subject)
	{
		String otp=new String(OTP(4));
		Properties props = new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
		Authentication auth = new Authentication();
		
		Session session = Session.getInstance(props,auth);
		
		try
		{
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject(subject);
			message.setContent("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"    <title></title>\r\n" + 
					"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n" + 
					"    <style type=\"text/css\">\r\n" + 
					"        body,\r\n" + 
					"        table,\r\n" + 
					"        td,\r\n" + 
					"        a {\r\n" + 
					"            -webkit-text-size-adjust: 100%;\r\n" + 
					"            -ms-text-size-adjust: 100%;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        table,\r\n" + 
					"        td {\r\n" + 
					"            mso-table-lspace: 0pt;\r\n" + 
					"            mso-table-rspace: 0pt;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        img {\r\n" + 
					"            -ms-interpolation-mode: bicubic;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        img {\r\n" + 
					"            border: 0;\r\n" + 
					"            height: auto;\r\n" + 
					"            line-height: 100%;\r\n" + 
					"            outline: none;\r\n" + 
					"            text-decoration: none;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        table {\r\n" + 
					"            border-collapse: collapse !important;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        body {\r\n" + 
					"            height: 100% !important;\r\n" + 
					"            margin: 0 !important;\r\n" + 
					"            padding: 0 !important;\r\n" + 
					"            width: 100% !important;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        a[x-apple-data-detectors] {\r\n" + 
					"            color: inherit !important;\r\n" + 
					"            text-decoration: none !important;\r\n" + 
					"            font-size: inherit !important;\r\n" + 
					"            font-family: inherit !important;\r\n" + 
					"            font-weight: inherit !important;\r\n" + 
					"            line-height: inherit !important;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        @media screen and (max-width: 480px) {\r\n" + 
					"            .mobile-hide {\r\n" + 
					"                display: none !important;\r\n" + 
					"            }\r\n" + 
					"\r\n" + 
					"            .mobile-center {\r\n" + 
					"                text-align: center !important;\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        /* ANDROID CENTER FIX */\r\n" + 
					"        div[style*=\"margin: 16px 0;\"] {\r\n" + 
					"            margin: 0 !important;\r\n" + 
					"        }\r\n" + 
					"    </style>\r\n" + 
					"\r\n" + 
					"<body style=\"margin: 0 !important; padding: 0 !important; background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\r\n" + 
					"    <!-- HIDDEN PREHEADER TEXT -->\r\n" + 
					"    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Open Sans, Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\r\n" + 
					"    </div>\r\n" + 
					"    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\" style=\"background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\r\n" + 
					"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 35px;\" bgcolor=\"#ff7361\">\r\n" + 
					"                            <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\">\r\n" + 
					"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\r\n" + 
					"                                    <tr>\r\n" + 
					"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 36px; font-weight: 800; line-height: 48px;\" class=\"mobile-center\">\r\n" + 
					"                                            <h1 style=\"font-size: 36px; font-weight: 800; margin: 0; color: #ffffff;\">EMBARQUES</h1>\r\n" + 
					"                                        </td>\r\n" + 
					"                                    </tr>\r\n" + 
					"                                </table>\r\n" + 
					"                            </div>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\" style=\"padding: 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\r\n" + 
					"                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-bottom: 15px; border-bottom: 3px solid #eeeeee;\"> <img src=\"https://pqcbog.sn.files.1drv.com/y4mVXjB7S7cZnBdRqM1cGhhhXV-QPXbenjb1Lopk7dBsayKQvcBeZYsoT2GsVB9X3FA1DFFiLE4yHdptoep0dr50pKA5gRV4Oqj1hA7aCKO4MTb8Eg25vvn7UlY95d2789gGewahnGjKRel0TprPoZYhL-f08Kh3USyZFgbcQQRM33RnbcV8R3TwVL1pHZJK1fSVgj87e-16iMOyZUDZvNIHA?width=598&height=600&cropmode=none\" width=\"190\" height=\"187\" style=\"display: block; border: 0px;\" /><br>\r\n" + 
					"                                        <h2 style=\"font-size: 30px; font-weight: 800; line-height: 36px; color: #333333; margin: 0;\"> Transporter Gave The Reply</h2>\r\n" + 
					"                                        <p style=\"font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;\">Please Checkout The Quotation Price</p>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"                     <tr>\r\n" + 
					"                    <td bgcolor=\"#ffffff\">\r\n" + 
					"                        <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\"> <br>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td align=\"center\"> <img src=\"https://cpnzlw.sn.files.1drv.com/y4mwD-IqgB4H2nKr1Ga5YXMQZAG8lI_nz3Au5lUHE9cWsAvAGH_6U5-sAP8nB0hm8Hqc0JyBlWH9-kBG23Ju6uq0mcmvVJq2JW0aFy3NcS-EbcfKT-slbY9XUOwinx37kjvYXTRLuVS2W9fvIpZhGZrUkh25xgE-HtZVjNpBidKCXTFDRTmDDaDhLdo7rj3BeWab-BoOUH-FG6-QLsS55LPhQ?width=1200&height=1200&cropmode=none\" width=\"137\" height=\"137\" style=\"display: block; border: 0px;\" /> </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 24px; padding: 5px 0 10px 0;\">\r\n" + 
					"                                    <p style=\"font-size: 14px; font-weight: 800; line-height: 18px; color: #333333;\">EMBARQUES<br>\r\n" + 
					"                                </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td style=\"padding: 0px 40px 10px 40px; font-family: sans-serif; font-size: 12px; line-height: 18px; color: #666666; text-align: center; font-weight:normal;\">\r\n" + 
					"                                    <p style=\"margin: 0;\">This email was sent to you from embaques123321@gmail.com</p>\r\n" + 
					"                                </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td style=\"padding: 0px 40px 40px 40px; font-family: sans-serif; font-size: 12px; line-height: 18px; color: #666666; text-align: center; font-weight:normal;\">\r\n" + 
					"                                    <p style=\"margin: 0;\">Copyright &copy; 2019-2020 , All Rights Reserved.</p>\r\n" + 
					"                                </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                        </table>\r\n" + 
					"                    </td>\r\n" + 
					"                </tr>\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"    </table>\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>", "text/html");
			
			Transport.send(message);
			return otp;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static String sendMailOrder(String to,String subject)
	{
		String otp=new String(OTP(4));
		System.out.println("OTP IS"+otp);
		Properties props = new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
		Authentication auth = new Authentication();
		
		Session session = Session.getInstance(props,auth);
		
		try
		{
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject(subject);
			message.setContent("<html>\n" +
	                    "<body>\n" +
	                    "\n" +
	                    "<a href=\"http://localhost:8081/main_panel/CUSTOMER/login.jsp\">\n" +
	                    "View Order from this link</a>\n" +
	                    "\n" +
	                    "</body>\n" +
	                    "</html>", "text/html");
			
			Transport.send(message);
			return otp;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static String sendMailDelivery(String to,String msg,String reply,String subject)
	{
		String otp=new String(OTP(4));
		System.out.println("OTP IS"+otp);
		Properties props = new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
		Authentication auth = new Authentication();
		
		Session session = Session.getInstance(props,auth);
		
		try
		{
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject(subject);
			message.setContent("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"    <title></title>\r\n" + 
					"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n" + 
					"    <style type=\"text/css\">\r\n" + 
					"        body,\r\n" + 
					"        table,\r\n" + 
					"        td,\r\n" + 
					"        a {\r\n" + 
					"            -webkit-text-size-adjust: 100%;\r\n" + 
					"            -ms-text-size-adjust: 100%;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        table,\r\n" + 
					"        td {\r\n" + 
					"            mso-table-lspace: 0pt;\r\n" + 
					"            mso-table-rspace: 0pt;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        img {\r\n" + 
					"            -ms-interpolation-mode: bicubic;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        img {\r\n" + 
					"            border: 0;\r\n" + 
					"            height: auto;\r\n" + 
					"            line-height: 100%;\r\n" + 
					"            outline: none;\r\n" + 
					"            text-decoration: none;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        table {\r\n" + 
					"            border-collapse: collapse !important;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        body {\r\n" + 
					"            height: 100% !important;\r\n" + 
					"            margin: 0 !important;\r\n" + 
					"            padding: 0 !important;\r\n" + 
					"            width: 100% !important;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        a[x-apple-data-detectors] {\r\n" + 
					"            color: inherit !important;\r\n" + 
					"            text-decoration: none !important;\r\n" + 
					"            font-size: inherit !important;\r\n" + 
					"            font-family: inherit !important;\r\n" + 
					"            font-weight: inherit !important;\r\n" + 
					"            line-height: inherit !important;\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        @media screen and (max-width: 480px) {\r\n" + 
					"            .mobile-hide {\r\n" + 
					"                display: none !important;\r\n" + 
					"            }\r\n" + 
					"\r\n" + 
					"            .mobile-center {\r\n" + 
					"                text-align: center !important;\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        div[style*=\"margin: 16px 0;\"] {\r\n" + 
					"            margin: 0 !important;\r\n" + 
					"        }\r\n" + 
					"    </style>\r\n" + 
					"\r\n" + 
					"<body style=\"margin: 0 !important; padding: 0 !important; background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\r\n" + 
					"    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Open Sans, Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\r\n" + 
					"       Shipment Receipt\r\n" + 
					"    </div>\r\n" + 
					"    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
					"        <tr>\r\n" + 
					"            <td align=\"center\" style=\"background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\r\n" + 
					"                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 35px;\" bgcolor=\"#F44336\">\r\n" + 
					"                            <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\">\r\n" + 
					"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\r\n" + 
					"                                    <tr>\r\n" + 
					"                                        <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 36px; font-weight: 800; line-height: 48px;\" class=\"mobile-center\">\r\n" + 
					"                                            <h1 style=\"font-size: 36px; font-weight: 800; margin: 0; color: #ffffff;\">EMBARQUES</h1>\r\n" + 
					"                                        </td>\r\n" + 
					"                                    </tr>\r\n" + 
					"                                </table>\r\n" + 
					"                            </div>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\" style=\"padding: 35px 35px 20px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\r\n" + 
					"                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\"> <img src=\"https://img.icons8.com/carbon-copy/100/000000/checked-checkbox.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" /><br>\r\n" + 
					"                                        <h2 style=\"font-size: 30px; font-weight: 800; line-height: 36px; color: #333333; margin: 0;\"> Thank You For Your Shipment! </h2>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px;\">\r\n" + 
					"                                        <p style=\"font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;\"> We hope that our service give you satisfaction. . </p>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"left\" style=\"padding-top: 20px;\">\r\n" + 
					"                                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td width=\"75%\" align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> Order Confirmation # </td>\r\n" + 
					"                                                <td width=\"25%\" align=\"left\" bgcolor=\"#eeeeee\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;\"> 2345678 </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\"> Shippemnet Price </td>\r\n" + 
					"                                                <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;\"> "+reply+" INR </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                        </table>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"left\" style=\"padding-top: 20px;\">\r\n" + 
					"                                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
					"                                            <tr>\r\n" + 
					"                                                <td width=\"75%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\"> TOTAL </td>\r\n" + 
					"                                                <td width=\"25%\" align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;\">"+reply+"INR </td>\r\n" + 
					"                                            </tr>\r\n" + 
					"                                        </table>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"                    <tr>\r\n" + 
					"                        <td align=\"center\" style=\" padding: 35px; background-color: #ff7361;\" bgcolor=\"#1b9ba3\">\r\n" + 
					"                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\r\n" + 
					"                                <tr>\r\n" + 
					"                                    <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\r\n" + 
					"                                        <h2 style=\"font-size: 24px; font-weight: 800; line-height: 30px; color: #ffffff; margin: 0;\"> Give Your valuable Rating to Transporter. </h2>\r\n" + 
					"                                    </td>\r\n" + 
					"                                </tr>\r\n" + 
					"                               " + 
					"                            </table>\r\n" + 
					"                        </td>\r\n" + 
					"                    </tr>\r\n" + 
					"                   <td bgcolor=\"#ffffff\">\r\n" + 
					"                        <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\"> <br>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td align=\"center\"> <img src=\"https://img.icons8.com/dusk/64/000000/ms-share-point.png\" width=\"37\" height=\"37\" style=\"display: block; border: 0px;\" /> </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 24px; padding: 5px 0 10px 0;\">\r\n" + 
					"                                    <p style=\"font-size: 14px; font-weight: 800; line-height: 18px; color: #333333;\">EMBARQUES<br>\r\n" + 
					"                                </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td style=\"padding: 0px 40px 10px 40px; font-family: sans-serif; font-size: 12px; line-height: 18px; color: #666666; text-align: center; font-weight:normal;\">\r\n" + 
					"                                    <p style=\"margin: 0;\">This email was sent to you from embaques123321@gmail.com</p>\r\n" + 
					"                                </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                            <tr>\r\n" + 
					"                                <td style=\"padding: 0px 40px 40px 40px; font-family: sans-serif; font-size: 12px; line-height: 18px; color: #666666; text-align: center; font-weight:normal;\">\r\n" + 
					"                                    <p style=\"margin: 0;\">Copyright &copy; 2019-2020 , All Rights Reserved.</p>\r\n" + 
					"                                </td>\r\n" + 
					"                            </tr>\r\n" + 
					"                        </table>\r\n" + 
					"                    </td>\r\n" + 
					"                </table>\r\n" + 
					"            </td>\r\n" + 
					"        </tr>\r\n" + 
					"    </table>\r\n" + 
					"</body>\r\n" + 
					"\r\n" + 
					"</html>", "text/html");
			
			Transport.send(message);
			return otp;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	static class Authentication extends Authenticator
	{
		@Override
		protected PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(fromMail,pass);
		}
		
	}

}
