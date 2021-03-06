package day0528;

public class PrintA implements Runnable {
	private static Object obj;
	private static Object obj2;
	
	public PrintA(Object obj, Object obj2) {
		PrintA.obj = obj;
		PrintA.obj2 = obj2;
	}

	@Override
	public void run() {
		for(int i=1; i<11; i++) {
			synchronized (obj) {
				synchronized (obj2) {
					System.out.println("A����"+i);
					obj2.notify();
				}
				try {
					if(i<10) {
						obj.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
