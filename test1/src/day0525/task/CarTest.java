package day0525.task;

public class CarTest {
	private static final Object obj = new Object();
	
	public static void main(String[] args) {
		new Thread(new HandCar("手推车1号", obj)).start();
		new Thread(new HandCar("手推车2号", obj)).start();
		new Thread(new HandCar("手推车3号", obj)).start();
		new Thread(new HandCar("手推车4号", obj)).start();
		
		new Thread(new SmallCar("小汽车1号", obj)).start();
		new Thread(new SmallCar("小汽车2号", obj)).start();
		new Thread(new SmallCar("小汽车3号", obj)).start();
		
		new Thread(new BigCar("大汽车1号", obj)).start();
		new Thread(new BigCar("大汽车2号", obj)).start();
	}
}
