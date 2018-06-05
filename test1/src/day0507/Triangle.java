package day0507;

public class Triangle {
	/**
	 * 利用底和高求三角形面积
	 * @param a 三角形的底边
	 * @param h 三角形的高
	 */
	public void getArea(int a,int h) {
		double area = a * h / 2;
		System.out.println(area);
	}
	/**
	 * 求三角形面积
	 * @param a 三角形其中一边
	 * @param b 三角形另外一边
	 * @param angle a边和b边夹角的正弦
	 */
	public void getArea(int a,int b, double angle) {
		double area = a * b * Math.sin(angle) / 2;
		System.out.println(area);
	}
	/**
	 * 利用海伦公式求三角形面积
	 * @param a 三角形第一条边长
	 * @param b 三角形第二条边长
	 * @param c 三角形第三条边长
	 */
	public void getArea(int a,int b,int c) {
		double p = (a + b + c) / 2;
		double area = Math.sqrt( p * (p - a) * (p - b) * (p - c) );
		System.out.println(area);
	}
}
