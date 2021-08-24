package COM.CUSTOMER.BEAN;

public class BEAN_RATING_FILE {
	
	String rate;
	int quote_id,trans_id,user_id,package_order_id;
	public String GET_RATING()
	{
		return rate;
	}
	public void SET_RATING(String rate)
	{
		this.rate=rate;
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
	public int GET_PACKAGE_ORDER_ID()
	{
		return package_order_id;
	}
	public void SET_PACKAGE_ORDER_ID(int package_order_id)
	{
		this.package_order_id=package_order_id;
	}

}
