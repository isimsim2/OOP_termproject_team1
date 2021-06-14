
public class Lecture {
	String subject;
	String period;
	String professorName;
	String lectureRoom;
	String email;
	String phoneNumber;
	String webexLink;
	
	public void setInfo(String subject, String period, String professorName, String lectureRoom, String email,
			String phoneNumber, String webexLink) {
		this.subject = subject;
		this.period = period;
		this.professorName = professorName;
		this.lectureRoom = lectureRoom;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.webexLink = webexLink;
	}
	
	public String[] getInfo() {
		String[] tmp_info = {this.subject, this.period, this. professorName, this. lectureRoom, this. email,
				this. phoneNumber, this. webexLink};
		return tmp_info;
	}
}
