package COM.CUSTOMER.BEAN;

public class BEAN_SUB_CATEGORY_FILE {
	
	private String sub_category_name;
	private int sub_category_id;
	private int category_id;
	private String category_name;
	
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
}
