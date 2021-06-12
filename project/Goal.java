package project;

public class Goal extends Plan
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
		return super.getInfo() + "   " + content + "   " + "Áß¿äµµ: " + importance;
	}


}
