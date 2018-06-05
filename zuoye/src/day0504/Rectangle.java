package day0504;
/**
 * ���峤�����࣬�����Կ��ߣ����ͣ������������ܳ������
 * @author Administrator+
 * 
 */
public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public Rectangle() {}
	/**
	 * ���㳤�����ܳ�
	 * @return �ܳ�
	 */
	public int getPerimeter() {
		return ( this.getWidth() + this.getHeight() )*2;
	}
	/**
	 * ���㳤�������
	 * @return ���
	 */
	public int getArea() {
		return this.getWidth() * this.getHeight();
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
