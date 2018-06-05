package day0525;

public class RunnableTest {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread th1 = new Thread(mr);
		Thread th2 = new Thread(mr);
		th1.start();
		th2.start();
		
		new Thread() {
			@Override
			public void run() {
				for(int i=50; i>=1; i--) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"..."+i);
				}
			}
		}.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=50; i>=1; i--) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"..."+i);
				}
			}
		}).start();
	}
}
