package day0525.task;

public class CarTest {
	private static final Object obj = new Object();
	
	public static void main(String[] args) {
		new Thread(new HandCar("���Ƴ�1��", obj)).start();
		new Thread(new HandCar("���Ƴ�2��", obj)).start();
		new Thread(new HandCar("���Ƴ�3��", obj)).start();
		new Thread(new HandCar("���Ƴ�4��", obj)).start();
		
		new Thread(new SmallCar("С����1��", obj)).start();
		new Thread(new SmallCar("С����2��", obj)).start();
		new Thread(new SmallCar("С����3��", obj)).start();
		
		new Thread(new BigCar("������1��", obj)).start();
		new Thread(new BigCar("������2��", obj)).start();
	}
}
