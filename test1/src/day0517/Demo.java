package day0517;

public class Demo {
	public static void main(String[] args) {
		//����ж�һ�������Ƿ��л�
		
		//����2����������ж������Ƿ��ཻ
		
		//�Լ�дһ��ջ��ʵ��push��pop��peek��size����
		MyStack mystack = new MyStack();
		mystack.push("aa");
		mystack.push("bb");
		mystack.push("cc");
		mystack.push("df");
		mystack.push("gf");
		mystack.push("er");
		System.out.println(mystack.pop());
		System.out.println(mystack.peek());
		System.out.println(mystack);
	}
}
