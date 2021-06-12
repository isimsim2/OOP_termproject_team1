package project;

public class appointment extends plan
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
		return super.getInfo() + "   " + content + "   " + "만나는 사람: " + friendName;
	}
	
}
