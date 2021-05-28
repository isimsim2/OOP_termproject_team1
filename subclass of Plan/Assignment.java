/**
 * Assignment class that inherit Plan class
 * Author : Lee Min A
 * Last modify : 2021 / 05 / 29
 * Term project of OOP_Team 1
 */
public class Assignment extends Plan{
	private String difficulty;
	
	// declare default constructor
	public Assignment() {
		super();
		this.difficulty = "No assignment yet.";
	}
	
	// declare explicit constructor
	public Assignment(String content) {
		super(content);
		this.difficulty = "No assignment yet.";
	}
	
	public Assignment(String content, String difficulty) {
		super(content);
		this.difficulty = difficulty;
	}
	
	// display all content and name of the plan
	public void showInfo() {
		super.showInfo();
		System.out.println(" : " + difficulty);
	}
	
	// add new plan
	public void addPlan(String day, String content, String difficulty) {
		super.addPlan(day, content);
		this.difficulty = difficulty;
	}
	
	// get a content's difficulty
	public String getDifficulty() {
		return difficulty;
	}
	
	// set a content's difficulty
	public void setPersonName(String difficulty) {
		this.difficulty = difficulty;
	}
}
