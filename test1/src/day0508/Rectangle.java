package day0508;
/**
 * ����һ���������࣬ӵ�����¹��ܣ�
 *   A���ܹ��ж�2���������Ƿ��ص�[�ཻ]
 *   B���ܹ�����2�����������ĵ�ľ���
 * @author Administrator
 */
public class Rectangle {
	private float x;
	private float y;
	private float width;
	private float height;
	
	public Rectangle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public Rectangle() {}
	
	public static boolean isIntersection(Rectangle rect1,Rectangle rect2) {
//		double rightButtomX1 = rect1.x<=0 ? rect1.x - rect1.width : rect1.x + rect1.width;
//		double rightButtomY1 = rect1.y<=0 ? rect1.y - rect1.width : rect1.y + rect1.width;
//		double rightButtomX2 = rect2.x<=0 ? rect2.x - rect2.width : rect2.x + rect2.width;
//		double rightButtomY2 = rect2.y<=0 ? rect2.y - rect2.width : rect2.y + rect2.width;		
		
		if(Math.abs(rect1.x-rect2.x) <= (rect1.width+rect2.width)/2 && Math.abs(rect1.y-rect2.y) <= (rect1.height + rect2.height)/2) {
			return true;
		}
		return false;
	}
	
}
