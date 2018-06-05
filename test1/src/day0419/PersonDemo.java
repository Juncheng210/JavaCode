package day0419;

public class PersonDemo {
	public static void main(String[] args) {
		Person a = new Person("уехЩ", 22);
		System.out.println(a.getName());
		a.setAge(24);
		System.out.println(a.isSex());
	}
}
