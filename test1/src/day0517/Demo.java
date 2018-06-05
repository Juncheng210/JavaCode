package day0517;

public class Demo {
	public static void main(String[] args) {
		//如何判断一个链表是否有环
		
		//给定2个链表，如何判断它们是否相交
		
		//自己写一个栈，实现push、pop、peek、size方法
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
