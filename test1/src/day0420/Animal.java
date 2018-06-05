package day0420;

public class Animal {
	private String type;
	private int age;
	private String color;
	
	public Animal(String type,int age,String color) {
		this.type = type;
		this.age = age;
		this.color = color;
	}
	
	public Animal() {
		
	}
	
	public void work() {
		System.out.println("动物工作");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
