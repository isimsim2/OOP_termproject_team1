import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Implement Plan class.
 * @author Seo Eun Su.
 * last modified 2021-05-25.
 */
public class Plan extends DateInfo {
	private String content;
	
	// Declare constructors.
	public Plan() {
		super();
		this.content = "No plan yet.";
	}
	public Plan(String day) {
		super(day);
		this.content = "No plan yet.";
	}
	public Plan(String day, String content) {
		this(day);
		this.content = content;
	}
	
	// Add new plan.
	public void addPlan(String day, String content) {
		setDay(day);
		this.content = content;
	}
	
	// Display all contents of the plan.
	public void showInfo() {
		System.out.println(getDay() + " : " + content);
	}
	
	// Calculate how much time is left until the appointed time. (appointed time - time now)
	private String calRemainingTime() {
		SimpleDateFormat inputDayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date appointmentDate = inputDayFormat.parse(getDay());
			long calDate = appointmentDate.getTime() - getCurrentTime().getTime();
			
			if (calDate < 0)
				throw new Exception("Exception: It's already past time.");

			long remainingDays = calDate / (24 * 60 * 60 * 1000);
			calDate -= remainingDays * (24 * 60 * 60 * 1000);
			long remainingHours = calDate / (60 * 60 * 1000);
			calDate -= remainingHours * (60 * 60 * 1000);
			long remainingMinutes = calDate / (60 * 1000);
			calDate -= remainingMinutes * (60 * 1000);
			long remainingSeconds = calDate / 1000;
			
			return Long.toString(remainingDays) + " days " + Long.toString(remainingHours) + ":" + Long.toString(remainingMinutes) + ":" + Long.toString(remainingSeconds);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return null;
	}
	// Get a remaining time that how much time is left until the appointment.
	public String getRemainingTime() {
		return calRemainingTime();	// It is implemented so that calRemainingTime() can be called only when getRemainingTime is called.
	}
	
	// Get a content of the plan.
	public String getContent() {
		return content;
	}
	// Set a content of the plan.
	public void setContent(String content) {
		this.content = content;
	}
}