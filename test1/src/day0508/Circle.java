package day0508;
/**
 * ����һ��Բ�࣬ӵ�����¹��ܣ�
 *   A���ܹ��ж�2��Բ�Ƿ�����
 *   B���ܹ��ж�2��Բ�Ƿ����
 * @author Administrator
 */
public class Circle {
	private double x;
	private double y;
	private double r;
	
	public Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	public Circle() {}
	/**
	 * �ж�2��Բ�Ƿ�����
	 * @param c1 ��һ��Բ
	 * @param c2 �ڶ���Բ
	 * @return
	 */
	public boolean isTangent(Circle c1,Circle c2) {
		double dis = Math.sqrt( (c1.x-c2.x) * (c1.x-c2.x) + (c1.y-c2.y) * (c1.y-c2.y) );
		if(dis==c1.r+c2.r || dis==Math.abs(c1.r-c2.r)) {
			return true;
		}
		return false;
	}
}
