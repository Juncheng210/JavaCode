package day0420;

public class Cat extends Animal {
	public static void main(String[] args) {
		Animal a = new Animal("����",4,"��ɫ");
		System.out.println(a.getColor());;
		a.work();
		
		System.out.println("---------�����ķָ���----------");
		
		Cat c = new Cat();
		System.out.println(c.getColor());
		c.action();
		c.work();
	}
	
	public void action() {
		System.out.println("����");
	}
	
	public void work() {
		System.out.println("ץ����");
	}
}
