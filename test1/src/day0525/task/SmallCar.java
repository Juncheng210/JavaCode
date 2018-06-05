package day0525.task;

public class SmallCar implements Runnable {
	private String name;
	private static Object obj;
	
	public SmallCar(String name, Object obj) {
		this.name = name;
		SmallCar.obj = obj;
	}
	
	@Override
	public void run() {
		synchronized (obj) {
			System.out.println(this.name+"过桥中");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name+"过完桥了");
		}
	}
}
