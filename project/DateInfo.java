import java.util.Date;
/**
 * Implement DateInfo class.
 * @author Seo Eun Su.
 * last modified 2021-05-25.
 */
public class DateInfo {
	private String day;
	// Bring the time now
	Date currentTime = new Date(System.currentTimeMillis());
	
	// Declare constructors.
	public DateInfo() {
		day = "The date has not yet been set.";
	}
	public DateInfo(String day) {
		this.day = day;
	}
	
	// Return the day
	public String getDay() {
		return day;
	}
	
	/* Set the new day
	   day format should be like 2021-05-25 11:00:00. */
	public void setDay(String day) {
		this.day = day;
	}
	
	// Return the time now
	public Date getCurrentTime() {
		return currentTime;
	}
}