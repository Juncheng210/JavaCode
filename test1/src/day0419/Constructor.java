package day0419;
//构造函数
public class Constructor {
	public String name;
	private int age;
	public String color;
	public String country;
	
	public static void main(String[] args) {
		Constructor a = new Constructor("张三",25,"黄色");
		System.out.println(a.name);
		System.out.println(a.age);
		System.out.println(a.color);
		System.out.println(a.country);
	}
	
	public Constructor(String name,int age,String color) {
		this.name = name;
		this.age = age;
		this.color = color;
	}
	public Constructor() {
		
	}
	public int getAge() {
		return this.age;
	}

	
	
}
