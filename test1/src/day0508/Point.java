package day0508;
/**
 * 创建一个点类，拥有以下功能：
 *   A、能够计算2点 间的距离
 *   B、能够判断3点是否能构成三角形
 * @author Administrator
 */
public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Point() {}
	/**
	 * 计算两点距离
	 * @param p1 第一个点
	 * @param p2 第二个点
	 * @return double
	 */
	public static double getDistance(Point p1,Point p2) {
		double x1 = p1.x - p2.x;
		double y1 = p1.y - p2.y;
		return Math.sqrt(y1*y1 + x1*x1);
	}
	/**
	 * 判断3点是否能构成三角形
	 * @param p1 第一个点
	 * @param p2 第二个点
	 * @param p3 第三个点
	 * @return boolean
	 */
	public static boolean isTriangle(Point p1,Point p2,Point p3) {
		double a = getDistance(p1, p2);
		double b = getDistance(p2, p3);
		double c = getDistance(p1, p3);
		double p = (a + b + c) / 2;
		if( Math.sqrt(p*(p-a)*(p-b)*(p-c))==0 ) {
			return false;
		}
		return true;
	}
}
