/**
 * Goal class that inherit Plan class
 * Author : Lee Min A
 * Last modify : 2021 / 05 / 29
 * Term project of OOP_Team 1
 */
public class Goal extends Plan{
	private String importance;
	
	// declare default constructor
	public Goal() {
		super();
		this.importance = "No goal yet.";
	}
	
	// declare explicit constructor
	public Goal(String content) {
		super(content);
		this.importance = "No goal yet.";
	}
	
	public Goal(String content, String importance) {
		super(content);
		this.importance = importance;
	}
	
	// display all content and name of the plan
	public void showInfo() {
		super.showInfo();
		System.out.println(" : " + importance);
	}
	
	// add new plan
	public void addPlan(String day, String content, String importance) {
		super.addPlan(day, content);
		this.importance = importance;
	}
	
	// get a content's importance
	public String getimportance() {
		return importance;
	}
	
	// set a content's importance
	public void setImportance(String importance) {
		this.importance = importance;
	}
}
