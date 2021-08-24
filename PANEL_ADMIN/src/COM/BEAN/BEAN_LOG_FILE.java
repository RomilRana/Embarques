package COM.BEAN;

public class BEAN_LOG_FILE {
private int admin_id,contact;
	
	private String admin_name,first_name,last_name,admin_password;

	public int GET_ADMIN_ID()
	{
		return admin_id;
	}
	public void SET_ADMIN_ID(int admin_id)
	{
		this.admin_id=admin_id;
	}
	
	public String GET_ADMIN_NAME()
	{
		return admin_name;
	}
	public void SET_ADMIN_NAME(String admin_name)
	{
		this.admin_name=admin_name;
	}
	
	public String GET_ADMIN_PASSWORD()
	{
		return admin_password;
	}
	public void SET_ADMIN_PASSWORD(String admin_password)
	{
		this.admin_password=admin_password;
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
	
	public int GET_CONTACT()
	{
		return contact;
	}
	public void SET_CONTACT(int contact)
	{
		this.contact=contact;
	}

}
