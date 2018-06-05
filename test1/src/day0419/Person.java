package day0419;

public class Person {
	private String name;
	private int age;
	private boolean sex;
	private int salary;
	
	public void eat() {
		System.out.println("³Ô·¹-");
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.salary = salary;
	}

	public Person() {
		super();
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

	public void setAge(int age) {
		this.age = age;
	}
	
}
