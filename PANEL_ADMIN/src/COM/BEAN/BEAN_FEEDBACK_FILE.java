package COM.BEAN;

public class BEAN_FEEDBACK_FILE {
	
	private String user_name,user_mail,description;
	
	public String GET_USER_NAME()
	{
		return user_name;
	}
	public void SET_USER_NAME(String user_name)
	{
		this.user_name=user_name;
	}
	
	public String GET_USER_MAIL()
	{
		return user_mail;
	}
	public void SET_USER_MAIL(String user_mail)
	{
		this.user_mail=user_mail;
	}
	
	public String GET_DESCRIPTION()
	{
		return description;
	}
	public void SET_DESCRIPTION(String description)
	{
		this.description=description;
	}


}
