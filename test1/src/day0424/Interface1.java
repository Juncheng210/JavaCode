package day0424;

public interface Interface1 {
	void eat();
	
	static void staticMethod() {
		System.out.println("�ӿ��еľ�̬����");
	}
	
	default void test() {
		System.out.println("�ӿ��е�Ĭ�Ϸ���");
	}
}
