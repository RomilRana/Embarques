package COM.TRANSPORTER.BEAN;

public class BEAN_LOG_FILE {
private int user_id;
	
	private String user_name,first_name,last_name,user_password,contact;

	public int GET_TRANSPORTER_ID()
	{
		return user_id;
	}
	public void SET_TRANSPORTER_ID(int user_id)
	{
		this.user_id=user_id;
	}
	
	public String GET_TRANSPORTER_NAME()
	{
		return user_name;
	}
	public void SET_TRANSPORTER_NAME(String user_name)
	{
		this.user_name=user_name;
	}
	
	public String GET_TRANSPORTER_PASSWORD()
	{
		return user_password;
	}
	public void SET_TRANSPORTER_PASSWORD(String user_password)
	{
		this.user_password=user_password;
	}
	
	public String GET_FIRST_NAME()
	{
		return first_name;
	}
	public void SET_FIRST_NAME(String first_name)
	{
		this.first_name=first_name;
	}
	
	public String GET_LAST_NAME()
	{
		return last_name;
	}
	public void SET_LAST_NAME(String last_name)
	{
		this.last_name=last_name;
	}
	
	public String GET_CONTACT()
	{
		return contact;
	}
	public void SET_CONTACT(String contact)
	{
		this.contact=contact;
	}

}
