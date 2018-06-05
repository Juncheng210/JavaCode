package day0424;

public class Test {
	public static void main(String[] args) {
		Implements a = new Implements();
		a.eat();
		a.sleep();
		a.test();
		Interface1 b = new Interface1() {
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				
			}
		};
		Interface1.staticMethod();
	}
}
