/**
 * Implement ProjectDemo class. (Just for checking the class running well.)
 * @author Seo Eun Su.
 * last modified 2021-05-25.
 */
public class ProjectDemo {
	// Test the class.
	public static void main(String[] args) {
		Plan p1 = new Plan();
		p1.getDay();
		System.out.println(p1.getCurrentTime());
		p1.addPlan("2021-06-02 00:00:00", "Project Deadline.");
		p1.showInfo();

		System.out.println(p1.getRemainingTime());
		p1.setContent("Term Project Deadline!");
		p1.showInfo();
	}
}