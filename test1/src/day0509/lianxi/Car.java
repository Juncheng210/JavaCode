package day0509.lianxi;

public class Car {
	private String mark;

	public Car(String mark) {
		this.mark = mark;
	}
	public Car() {}
	
	/**
	 * ���ܣ���ʻ
	 */
	public void drive() {
		System.out.println("�������ڼ�ʻ");
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
