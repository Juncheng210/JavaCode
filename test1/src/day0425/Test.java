package day0425;

import day0425.Outer.Inner;
import day0425.Outer.StaticInner;

public class Test {
	public static void main(String[] args) {
		//成员内部类
		//访问内部类，写法一（同包内，此种写法无需导包）
		Outer.Inner in1 = new Outer().new Inner();
		in1.inner();
		System.out.println("-------------华丽的分割线---------------");
		//访问内部类，写法二（同包内，此种写法需要导包）
		Inner in2 = new Outer().new Inner();
		in2.inner();
		System.out.println("-------------华丽的分割线---------------");
		//访问内部类，写法三（同包内，此种写法需要导包）
		Outer out = new Outer();
		Inner in3 = out.new Inner();
		in3.inner();
		System.out.println("-------------华丽的分割线---------------");
		
		//静态内部类（同包内，此种写法需要导包）
		StaticInner sin = new StaticInner();
		System.out.println(sin.s);
		System.out.println(sin.s1);
		sin.fun1();
		System.out.println("-------------华丽的分割线---------------");
		
		//局部内部类
		Outer1 out1 = new Outer1();
		out1.fun();
		System.out.println("-------------华丽的分割线---------------");
		
		//匿名内部类
		IOuter io = new IOuter() {
			
			@Override
			public void work() {
				System.out.println("工作");
			}
			
			@Override
			public void eat() {
				System.out.println("吃东西");
			}
		};
		io.eat();
		io.work();
	}
}
