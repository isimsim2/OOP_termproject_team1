package project;

public class date 
{
	public String month;
	public String day;
	public String dayOfTheWeek; 
	public String time;
		
	public String getMonth() 
	{
		return month;
	}
	
	public String getDay() 
	{
		return day;
	}
	
	public String getDayOfTheWeek() 
	{
		return dayOfTheWeek;
	}
	
	public String getTime() 
	{
		return time;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setDayOfTheWeek(String dayOfTheWeek) 
	{
		this.dayOfTheWeek = dayOfTheWeek;
	}
	
}
