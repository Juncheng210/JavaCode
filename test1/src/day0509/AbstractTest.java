package day0509;

public class AbstractTest {
	public static void main(String[] args) {
//		AbstractDemo a = new AbstractDemo();//���������಻��ֱ��ʵ����
		AbstractDemo b = new AbstractDemo() {
			
			@Override
			public void eat() {
				System.out.println("�Է�");
			}
		};
		b.eat();
		AbstractExtends c = new AbstractExtends("111");
		c.eat();
		System.out.println(c.getName());
	}
}
