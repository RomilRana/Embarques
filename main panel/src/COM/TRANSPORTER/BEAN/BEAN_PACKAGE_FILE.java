package COM.TRANSPORTER.BEAN;



public class BEAN_PACKAGE_FILE {
	
	
	String image_name,package_name,from_name,to_name,package_description,transporter_name,user_name,description,company;
	int trans_id,price,package_id,user_id,from_id,to_id;
	
	public int GET_PACKAGE_ID()
	{
		return package_id;
	}
	public void SET_PACKAGE_ID(int package_id)
	{
		this.package_id=package_id;
	}
	
	
	public String GET_IMAGE_NAME()
	{
		return image_name;
	}
	public void SET_IMAGE_NAME(String image_name)
	{
		this.image_name=image_name;
	}
	
	public int GET_TRANSPORTER_ID()
	{
		return trans_id;
	}
	public void SET_TRANSPORTER_ID(int trans_id)
	{
		this.trans_id=trans_id;
	}
	
	public int GET_USER_ID()
	{
		return user_id;
	}
	public void SET_USER_ID(int user_id)
	{
		this.user_id=user_id;
	}
	public int GET_PACKAGE_PRICE()
	{
		return price;
	}
	public void SET_PACKAGE_PRICE(int price)
	{
		this.price=price;
	}
	
	
	public String GET_TRANSPORTER_NAME()
	{
		return transporter_name;
	}
	public void SET_TRANSPORTER_NAME(String transporter_name)
	{
		this.transporter_name=transporter_name;
	}
	
	public String GET_USER_NAME()
	{
		return user_name;
	}
	public void SET_USER_NAME(String user_name)
	{
		this.user_name=user_name;
	}
	
	
	public String GET_PACKAGE_NAME()
	{
		return package_name;
	}
	public void SET_PACKAGE_NAME(String package_name)
	{
		this.package_name=package_name;
	}
	
	public String GET_PACKAGE_DESCRIPTION()
	{
		return package_description;
	}
	public void SET_PACKAGE_DESCRIPTION(String package_description)
	{
		this.package_description=package_description;
	}
	
	public int GET_FROM_ID()
	{
		return from_id;
	}
	public void SET_FROM_ID(int from_id)
	{
		this.from_id=from_id;
	}
	
	public int GET_TO_ID()
	{
		return to_id;
	}
	public void SET_TO_ID(int to_id)
	{
		this.to_id=to_id;
	}
	
	public String GET_FROM_NAME()
	{
		return from_name;
	}
	public void SET_FROM_NAME(String from_name)
	{
		this.from_name=from_name;
	}
	
	public String GET_TO_NAME()
	{
		return to_name;
	}
	public void SET_TO_NAME(String to_name)
	{
		this.to_name=to_name;
	}
	
	public String GET_DESCRIPTION()
	{
		return description;
	}
	public void SET_DESCRIPTION(String description)
	{
		this.description=description;
	}
	
	public String GET_COMPANY()
	{
		return company;
	}
	public void SET_COMPANY(String company)
	{
		this.company=company;
	}
}
