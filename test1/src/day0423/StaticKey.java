package day0423;

public class StaticKey {
	public String name;
	public static String type;
	
	static {
		type = "dog";
	}
	
	public StaticKey(String name) {
//		super();
		this.name = name;
	}
	public StaticKey() {
//		super();
	}
	
	public void eat() {
		this.name = "";
		System.out.println("非静态方法");
	}
	public static void sleep() {
//		this.name = "";//静态方法中直接使用this会报错
		StaticKey.type = "";
		System.out.println("静态方法");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getType() {
		return type;
	}
	public static void setType(String type) {
		StaticKey.type = type;
	}
	
	
}
