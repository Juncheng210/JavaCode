package day0509.lianxi;

public class SubCar extends Car {
	private int price;
	private int speed;
	
	public SubCar(String mark, int price, int speed) {
		super(mark);
		this.price = price;
		this.speed = speed;
	}
	public SubCar() {}
	
	public void speed() {
		System.out.println(this.getMark()+"��ԭ�����ٶ���"+this.speed);
	}
	/**
	 * ���ܣ�����
	 * @param newSpeed �µ��ٶ�
	 */
	public void speedChange(int newSpeed) {
		System.out.println(getMark()+"�����ڵ��ٶ�Ϊ"+newSpeed);
		setSpeed(newSpeed);
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
