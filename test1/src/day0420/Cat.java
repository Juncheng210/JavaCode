package day0420;

public class Cat extends Animal {
	public static void main(String[] args) {
		Animal a = new Animal("动物",4,"花色");
		System.out.println(a.getColor());;
		a.work();
		
		System.out.println("---------华丽的分割线----------");
		
		Cat c = new Cat();
		System.out.println(c.getColor());
		c.action();
		c.work();
	}
	
	public void action() {
		System.out.println("卖萌");
	}
	
	public void work() {
		System.out.println("抓老鼠");
	}
}
