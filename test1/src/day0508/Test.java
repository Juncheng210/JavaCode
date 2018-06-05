package day0508;

public class Test {
	public static void main(String[] args) {
//		Father f = new Children();
//		f.work();
		Rectangle r1 = new Rectangle(0, 0, 5, 6);
		Rectangle r2 = new Rectangle(5, 6, 5, 6);
		boolean a = Rectangle.isIntersection(r1, r2);
		System.out.println(a);
	}
}
