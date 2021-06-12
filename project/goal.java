package project;

public class goal extends plan
{
	public String importance;
		
	public String getImportance() 
	{
		return importance;
	}
		
		
	public void setImportance(String importance) 
	{
		this.importance = importance;
	}
	
	//overriding
	public String getInfo() 
	{
		return super.getInfo() + "   " + content + "   " + "�߿䵵: " + importance;
	}


}
