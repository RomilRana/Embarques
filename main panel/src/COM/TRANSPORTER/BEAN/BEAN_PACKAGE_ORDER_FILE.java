package COM.TRANSPORTER.BEAN;

public class BEAN_PACKAGE_ORDER_FILE {

	String image_name,package_name,from_name,to_name,package_description,transporter_name,user_name,description,company,reason,first_name,last_name,address,contact,cancel_date,cancel_by,company_name;
	int trans_id,price,package_id,user_id,from_id,to_id,p_id,package_order_id;
	
	public int GET_PACKAGE_BOOKING_ID()
	{
		return package_id;
	}
	public void SET_PACKAGE_BOOKING_ID(int package_id)
	{
		this.package_id=package_id;
	}
	
	public int GET_PACKAGE_ORDER_ID()
	{
		return package_order_id;
	}
	public void SET_PACKAGE_ORDER_ID(int package_order_id)
	{
		this.package_order_id=package_order_id;
	}
	public int GET_PACKAGE_ID()
	{
		return p_id;
	}
	public void SET_PACKAGE_ID(int p_id)
	{
		this.p_id=p_id;
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
	public String GET_REASON()
	{
		return reason;
	}
	public void SET_REASON(String reason)
	{
		this.reason=reason;
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
	
	public String GET_ADDRESS()
	{
		return address;
	}
	public void SET_ADDRESS(String address)
	{
		this.address=address;
	}
	
	public String GET_CONTACT()
	{
		return contact;
	}
	public void SET_CONTACT(String contact)
	{
		this.contact=contact;
	}
	public String GET_CANCEL_DATE()
	{
		return cancel_date;
	}
	public void SET_CANCEL_DATE(String cancel_date)
	{
		this.cancel_date=cancel_date;
	}
	
	public String GET_CANCEL_BY()
	{
		return cancel_by;
	}
	public void SET_CANCEL_BY(String cancel_by)
	{
		this.cancel_by=cancel_by;
	}
	public String GET_COMPANY_NAME()
	{
		return company_name;
	}
	public void SET_COMPANY_NAME(String company_name)
	{
		this.company_name=company_name;
	}
}
