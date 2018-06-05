package day0509.lianxi;

public class Student extends Person {
	private String school;
	private String id;
	
	public Student(String name, boolean sex, int age, String country, String school, String id) {
		super(name, sex, age, country);
		this.school = school;
		this.id = id;
	}
	public Student() {}

	@Override
	public void work() {
		System.out.println("ѧϰ");
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
