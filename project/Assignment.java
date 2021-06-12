package project;

public class Appointment extends Plan
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
		return super.getInfo() + "   " + content + "   " + "³­ÀÌµµ: "+ difficulty;
	}
}
