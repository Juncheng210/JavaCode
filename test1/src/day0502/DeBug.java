package day0502;

public class DeBug {
	public static void main(String[] args) {
		int i = 1;
		while(i<=10) {
			eat();
			i++;
		}
	}
	
	public static void eat() {
		System.out.println("�Է�");
		sleep();
	}
	public static void sleep() {
		System.out.println("˯��");
	}
}
