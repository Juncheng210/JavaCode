package day0509.lianxi;

public class Car {
	private String mark;

	public Car(String mark) {
		this.mark = mark;
	}
	public Car() {}
	
	/**
	 * 功能：驾驶
	 */
	public void drive() {
		System.out.println("本车正在驾驶");
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
