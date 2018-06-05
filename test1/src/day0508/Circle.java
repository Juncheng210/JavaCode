package day0508;
/**
 * 创建一个圆类，拥有以下功能：
 *   A、能够判断2个圆是否相切
 *   B、能够判断2个圆是否包含
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
	 * 判断2个圆是否相切
	 * @param c1 第一个圆
	 * @param c2 第二个圆
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
