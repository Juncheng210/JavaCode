package day0530.homework;

public class Student {
	private String name;
	private String idcard;
	private String examid;
	private String location;
	private int grade;
	
	public Student(String name, String idcard, String examid, String location, int grade) {
		super();
		this.name = name;
		this.idcard = idcard;
		this.examid = examid;
		this.location = location;
		this.grade = grade;
	}
	public Student() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
