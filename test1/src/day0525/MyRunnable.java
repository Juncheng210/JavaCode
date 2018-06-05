package day0525;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}
}
