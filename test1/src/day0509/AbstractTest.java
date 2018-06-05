package day0509;

public class AbstractTest {
	public static void main(String[] args) {
//		AbstractDemo a = new AbstractDemo();//报错，抽象类不能直接实例化
		AbstractDemo b = new AbstractDemo() {
			
			@Override
			public void eat() {
				System.out.println("吃饭");
			}
		};
		b.eat();
		AbstractExtends c = new AbstractExtends("111");
		c.eat();
		System.out.println(c.getName());
	}
}
