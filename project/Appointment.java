package project;

public class Appointment extends Plan
{
	public String friendName;
	
	public String getFriendName() 
	{
		return friendName;
	}
	
	public void setFriendName(String friendName) 
	{
		this.friendName = friendName;
	}
	
	//overriding
	public String getInfo() 
	{
		return super.getInfo() + "   " + content + "   " + "¸¸³ª´Â »ç¶÷: " + friendName;
	}
	
}
