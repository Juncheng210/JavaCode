package day0508;
/**
 * ����һ�����࣬ӵ�����¹��ܣ�
 *   A���ܹ�����2�� ��ľ���
 *   B���ܹ��ж�3���Ƿ��ܹ���������
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
	 * �����������
	 * @param p1 ��һ����
	 * @param p2 �ڶ�����
	 * @return double
	 */
	public static double getDistance(Point p1,Point p2) {
		double x1 = p1.x - p2.x;
		double y1 = p1.y - p2.y;
		return Math.sqrt(y1*y1 + x1*x1);
	}
	/**
	 * �ж�3���Ƿ��ܹ���������
	 * @param p1 ��һ����
	 * @param p2 �ڶ�����
	 * @param p3 ��������
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
