package COM.CUSTOMER.BEAN;

public class BEAN_NOTIFICATION_FILE {
private int quote_id,cust_id,user_id,trans_quote_id,notification_id;
	
	private String user_name,message,reply,trans_name,date_time;
	
	private String sub_category_name,destination_name,source_name;
	
	private int sub_category_id;
	
	private int category_id,source_id,destination_id;
	
	private String from_date,to_date;
	
	private String category_name;
	
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
		return cust_id;
	}
	public void SET_TRANS_ID(int cust_id)
	{
		this.cust_id=cust_id;
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
	
	public String GET_DATE_TIME()
	{
		return date_time;
	}
	public void SET_DATE_TIME(String date_time)
	{
		this.date_time=date_time;
	}
	
	public int GET_NOTIFICATION_ID()
	{
		return notification_id;
	}
	public void SET_NOTIFICATION_ID(int notification_id)
	{
		this.notification_id=notification_id;
	}
}


