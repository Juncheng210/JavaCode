package day0424;

public interface Interface2 extends Interface1 {
	void sleep();
	
	static void testStatic() {
		System.out.println("��̬��������");
	}
	
	default void testDefault() {
		System.out.println("Ĭ�Ϸ�������");
	}


	@Override
	default void test() {
		// TODO Auto-generated method stub
		Interface1.super.test();
	}
	
	
}
