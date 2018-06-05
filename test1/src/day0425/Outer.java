package day0425;

public class Outer {
	public String outer = "外部类变量";
	public String a = "外部类同名a变量";
	public static String a1 = "外部类静态变量";
	
	public void outer() {
		Inner in = new Inner();
		System.out.println("外部类访问内部类变量："+in.inner);//外部类访问内部类变量
		System.out.println("外部类方法");
	}
	
	public class Inner{
		public String inner = "内部类变量";
		public String a = "内部类同名a变量";
		
		public void inner() {
			System.out.println("内部类访问外部类变量："+outer);//内部类访问外部类变量
			System.out.println("内部类方法");
			outer();//内部类访问外部类方法
			System.out.println("内部类中访问内部类同名变量："+a);//调用内部类同名变量
			System.out.println("内部类中访问外部类同名变量："+Outer.this.a);//调用外部类同名变量
		}
	}
	
	public static class StaticInner{
		public String s = "静态内部类变量";
		public static String s1 = "静态内部类静态变量";
		
		public void fun1() {
			System.out.println("静态内部类方法");
			System.out.println("静态内部类中直接访问外部类静态变量"+a1);
		}
		public static void fun2() {
			System.out.println("静态内部类静态方法");
		}
	}
}
