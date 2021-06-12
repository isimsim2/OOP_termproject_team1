package project;

public class assignment extends plan
{
	public String difficulty;
	
	public String getDifficulty() 
	{
		return difficulty;
	}
	
	
	public void setDifficulty(String difficulty) 
	{
		this.difficulty = difficulty;
	}
	
	//overriding
	public String getInfo() 
	{
		return super.getInfo() + "   " + content + "   " + "≥≠¿Ãµµ: "+ difficulty;
	}
}
