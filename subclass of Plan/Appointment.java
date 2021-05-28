/**
 * Appointment class that inherit Plan class
 * Author : Lee Min A
 * Last modify : 2021 / 05 / 29
 * Term project of OOP_Team 1
 */
public class Appointment extends Plan {
	private String personName;
	
	// declare default constructor
	public Appointment() {
		super();
		this.personName = "No appointment yet.";
	}
	
	// declare explicit constructor
	public Appointment(String content) {
		super(content);
		this.personName = "No appointment yet.";
	}
	
	public Appointment(String content, String personName) {
		super(content);
		this.personName = personName;
	}
	
	// display all content and name of the plan
	public void showInfo() {
		super.showInfo();
		System.out.println(" : " + personName);
	}
	
	// add new plan
	public void addPlan(String day, String content, String personName) {
		super.addPlan(day, content);
		this.personName = personName;
	}
	
	// get a name of content's person
	public String getPersonName() {
		return personName;
	}
	
	// set a name of content's person
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
