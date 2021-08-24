package COM.CUSTOMER.BEAN;

public class BEAN_FEEDBACK_FILE {
	
	private int user_id;
	private String user_name,message,given_by;
	
	public int GET_USER_ID()
	{
		return user_id;
	}
	public void SET_USER_ID(int user_id)
	{
		this.user_id=user_id;
	}
	
	public String GET_USER_NAME()
	{
		return user_name;
	}
	public void SET_USER_NAME(String user_name)
	{
		this.user_name=user_name;
	}
	
	public String GET_MESSAGE()
	{
		return message;
	}
	public void SET_MESSAGE(String message)
	{
		this.message=message;
	}
	
	public String GET_GIVEN_BY()
	{
		return given_by;
	}
	public void SET_GIVEN_BY(String given_by)
	{
		this.given_by=given_by;
	}

}
