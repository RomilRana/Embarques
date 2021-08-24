package COM.CUSTOMER.BEAN;

public class BEAN_ORDER_FILE {
private int quote_id,trans_id,user_id,trans_quote_id,order_id;
	
	private String user_name,message,reply,trans_name,first_name,last_name,add,order_date,cancel_date,reason,name,company;
	
	private String from_date,to_date;
	
	private String sub_category_name,source_name,destination_name;
	
	private int sub_category_id;
	
	private int category_id,source_id,destination_id;
	
	private String category_name,contact;
	
	String image_name;
	public String GET_IMAGE_NAME()
	{
		return image_name;
	}
	public void SET_IMAGE_NAME(String image_name)
	{
		this.image_name=image_name;
	}
	
	public int GET_SOURCE_ID()
	{
		return source_id;
	}
	public void SET_SOURCE_ID(int source_id)
	{
		this.source_id=source_id;
	}
	
	
	
	public int GET_ORDER_ID()
	{
		return order_id;
	}
	public void SET_ORDER_ID(int order_id)
	{
		this.order_id=order_id;
	}
	
	public int GET_DESTINATION_ID()
	{
		return destination_id;
	}
	public void SET_DESTINATION_ID(int destination_id)
	{
		this.destination_id=destination_id;
	}
	
	public String GET_SOURCE_NAME()
	{
		return source_name;
	}
	public void SET_SOURCE_NAME(String source_name)
	{
		this.source_name=source_name;
	}
	
	public String GET_DESTINATION_NAME()
	{
		return destination_name;
	}
	public void SET_DESTINATION_NAME(String destination_name)
	{
		this.destination_name=destination_name;
	}
	
	public String GET_CATEGORY_NAME()
	{
		return category_name;
	}
	public void SET_CATEGORY_NAME(String category_name)
	{
		this.category_name=category_name;
	}
	
	public int GET_CATEGORY_ID()
	{
		return category_id;
	}
	public void SET_CATEGORY_ID(int category_id)
	{
		this.category_id=category_id;
	}
	
	public int GET_SUB_CATEGORY_ID()
	{
		return sub_category_id;
	}
	public void SET_SUB_CATEGORY_ID(int sub_category_id)
	{
		this.sub_category_id=sub_category_id;
	}
	
	public  String GET_SUB_CATEGORY_NAME()
	{
		return sub_category_name;
	}
	public void SET_SUB_CATEGORY_NAME(String sub_category_name)
	{
		this.sub_category_name=sub_category_name;
	}

	public int GET_QUOTE_ID()
	{
		return quote_id;
	}
	public void SET_QUOTE_ID(int quote_id)
	{
		this.quote_id=quote_id;
	}
	
	public int GET_TRANS_ID()
	{
		return trans_id;
	}
	public void SET_TRANS_ID(int trans_id)
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
	
	public String GET_USER_NAME()
	{
		return user_name;
	}
	public void SET_USER_NAME(String user_name)
	{
		this.user_name=user_name;
	}
	
	public String GET_TRANS_NAME()
	{
		return trans_name;
	}
	public void SET_TRANS_NAME(String trans_name)
	{
		this.trans_name=trans_name;
	}
	public String GET_MESSAGE()
	{
		return message;
	}
	public void SET_MESSAGE(String message)
	{
		this.message=message;
	}
	
	public String GET_REPLY()
	{
		return reply;
	}
	public void SET_REPLY(String reply)
	{
		this.reply=reply;
	}
	
	public String GET_FROM_DATE()
	{
		return from_date;
	}
	public void SET_FROM_DATE(String from_date)
	{
		this.from_date=from_date;
	}
	
	public String GET_TO_DATE()
	{
		return to_date;
	}
	public void SET_TO_DATE(String to_date)
	{
		this.to_date=to_date;
	}
	
	public int GET_TRANS_QUOTE_ID()
	{
		return trans_quote_id;
	}
	public void SET_TRANS_QUOTE_ID(int trans_quote_id)
	{
		this.trans_quote_id=trans_quote_id;
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
	
	public String GET_ADDRESS()
	{
		return add;
	}
	public void SET_ADDRESS(String add)
	{
		this.add=add;
	}
	public String GET_ORDER_DATE()
	{
		return order_date;
	}
	public void SET_ORDER_DATE(String order_date)
	{
		this.order_date=order_date;
	}
	public String GET_CANCEL_DATE()
	{
		return cancel_date;
	}
	public void SET_CANCEL_DATE(String cancel_date)
	{
		this.cancel_date=cancel_date;
	}
	public String GET_REASON()
	{
		return reason;
	}
	public void SET_REASON(String reason)
	{
		this.reason=reason;
	}
	public String GET_CANCEL_BY()
	{
		return name;
	}
	public void SET_CANCEL_BY(String name)
	{
		this.name=name;
	}
	public String GET_COMPANY_NAME()
	{
		return company;
	}
	public void SET_COMPANY_NAME(String company)
	{
		this.company=company;
	}
	
	
	
}
