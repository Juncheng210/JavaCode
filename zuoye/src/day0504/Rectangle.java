package day0504;
/**
 * 定义长方形类，含属性宽、高（整型），方法：求周长、面积
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
	 * 计算长方形周长
	 * @return 周长
	 */
	public int getPerimeter() {
		return ( this.getWidth() + this.getHeight() )*2;
	}
	/**
	 * 计算长方形面积
	 * @return 面积
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
