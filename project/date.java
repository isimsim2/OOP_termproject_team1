package project;
/**
 * Implement date class.
 * @author Seo Eun Su.
 * last modified 2021-06-12.
 */
public class date 
{
	// date Fields.
	public String month;
	public String day;
	public String dayOfTheWeek; 
	public String time;
	
	// Get a month.
	public String getMonth() 
	{
		return month;
	}
	
	// Get a day.
	public String getDay() 
	{
		return day;
	}
	
	// Get a day of the week.
	public String getDayOfTheWeek() 
	{
		return dayOfTheWeek;
	}
	
	// Get a time.
	public String getTime() 
	{
		return time;
	}
	
	// Set a month.
	public void setMonth(String month) {
		this.month = month;
	}
	
	// Set a day.
	public void setDay(String day) {
		this.day = day;
	}
	
	// Set a time.
	public void setTime(String time) {
		this.time = time;
	}
	
	// Set a day of the week.
	public void setDayOfTheWeek(String dayOfTheWeek) 
	{
		this.dayOfTheWeek = dayOfTheWeek;
	}
	
}
