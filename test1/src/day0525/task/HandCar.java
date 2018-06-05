package day0525.task;

public class HandCar implements Runnable {
	private String name;
	private static Object obj;
	
	public HandCar(String name, Object obj) {
		this.name = name;
		HandCar.obj = obj;
	}
	
	@Override
	public void run() {
		synchronized (obj) {
			System.out.println(this.name+"过桥中");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name+"过完桥了");
		}
	}
}
