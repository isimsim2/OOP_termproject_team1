package project;

public class lecture extends date
{
	public String subject;
	public String course;
	public String period;
	public String professorName;
	public String lectureRoom;
	public String email;
	public String webexLink;
	
	public String getSubject() 
	{
		return subject;
	}
	
	public String getcourse() 
	{
		return course;
	}
	
	public String getPeriod() 
	{
		return period;
	}
	
	public String getProfessorName() 
	{
		return professorName;
	}
	
	public String getLectureRoom() 
	{
		return lectureRoom;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public String getLink() 
	{
		return webexLink;
	}
	
	
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	
	public void setCourse(String course) 
	{
		this.course = course;
	}
	
	public void setPeriod(String period) 
	{
		this.period = period;
	}
	
	public void setProfessorName(String professorName) 
	{
		this.professorName = professorName;
	}
	
	public void setLectureRoom(String lectureRoom) 
	{
		this.lectureRoom = lectureRoom;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public void setLink(String webexLink) 
	{
		this.webexLink = webexLink;
	}
	
	
	/*
	 * 다른 오브젝트와 시간과 요일이 동일한지 확인
	 * */
	public boolean equals(Object obj) 
	{
		if(this.time == ((lecture)obj).time && this.dayOfTheWeek == ((lecture)obj).dayOfTheWeek) return true;
		else return false;	
	}
	
	
	
}
