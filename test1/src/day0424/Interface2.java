package day0424;

public interface Interface2 extends Interface1 {
	void sleep();
	
	static void testStatic() {
		System.out.println("静态方法测试");
	}
	
	default void testDefault() {
		System.out.println("默认方法测试");
	}


	@Override
	default void test() {
		// TODO Auto-generated method stub
		Interface1.super.test();
	}
	
	
}
