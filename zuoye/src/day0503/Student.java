package day0503;

public class Student {
	private String name;
	private int age;
	private int chinese;
	private int math;
	private int english;
	
	public Student() {}
	public Student(String name, int age, int chinese, int math, int english) {
		this.name = name;
		this.age = age;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", chinese=" + chinese + ", math=" + math + ", english="
				+ english + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}	
}
