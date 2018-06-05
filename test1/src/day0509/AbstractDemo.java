package day0509;

public abstract class AbstractDemo {
	private String name;
	
	public AbstractDemo() {}
	public AbstractDemo(String name) {
		this.name = name;
	}
	
	public void sleep() {
		System.out.println("Ë¯¾õ");
	}
	
	public abstract void eat();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
