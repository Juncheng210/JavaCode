package day0525.task;

public class BigCar implements Runnable {
	private String name;
	private static Object obj;
	
	public BigCar(String name, Object obj) {
		this.name = name;
		BigCar.obj = obj;
	}
	
	@Override
	public void run() {
		synchronized (obj) {
			System.out.println(this.name+"������");
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name+"��������");
		}
	}
}
