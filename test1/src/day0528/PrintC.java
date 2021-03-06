package day0528;

public class PrintC implements Runnable {
	private static Object obj;
	private static Object obj2;
	
	public PrintC(Object obj, Object obj2) {
		PrintC.obj = obj;
		PrintC.obj2 = obj2;
	}
	
	@Override
	public void run() {
		for(int i=1; i<11; i++) {
			synchronized (obj) {
				synchronized (obj2) {
					System.out.println("C����"+i);
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
