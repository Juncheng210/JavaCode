package day0424;

public class Implements implements Interface2 {
	@Override
	public void eat() {
		System.out.println("�Զ���");
	}
	
	@Override
	public void sleep() {
		System.out.println("˯��");
	}

	@Override
	public void test() {
		Interface2.super.test();
	}

	@Override
	public void testDefault() {
		Interface2.super.testDefault();
	}

	
	

	
	
	
	
}
