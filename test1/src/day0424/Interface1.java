package day0424;

public interface Interface1 {
	void eat();
	
	static void staticMethod() {
		System.out.println("接口中的静态方法");
	}
	
	default void test() {
		System.out.println("接口中的默认方法");
	}
}
