package day0509.lianxi;

public class Person {
	private String name;
	private boolean sex;
	private int age;
	private String country;
	
	public Person(String name, boolean sex, int age, String country) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.country = country;
	}
	public Person() {}
	
	public void eat() {
		System.out.println("³Ô·¹");
	}
	public void sleep() {
		System.out.println("Ë¯¾õ");
	}
	public void work() {
		System.out.println("¹¤×÷");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
