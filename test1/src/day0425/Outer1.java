package day0425;

public class Outer1 {
	public void fun() {
		class Inner1{
			int a = 1;
		}
		Inner1 in = new Inner1();
		System.out.println(in.a);
	}
}
