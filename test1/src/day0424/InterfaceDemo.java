package day0424;

public class InterfaceDemo implements Interface {
	public static void main(String[] args) {
		Interface i = new InterfaceDemo();
		i.eat();
		i.work();
		String str = Interface.NAME;
		System.out.println(NAME);
	}
	@Override
	public void eat() {
		System.out.println("�Դ��");
	}

	@Override
	public void work() {
		System.out.println("�ô���");
	}

}
