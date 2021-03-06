package day0528;

public class PrintB implements Runnable {
	private static Object obj;
	private static Object obj2;
	
	public PrintB(Object obj, Object obj2) {
		PrintB.obj = obj;
		PrintB.obj2 = obj2;
	}
	
	@Override
	public void run() {
		for(int i=1; i<11; i++) {
			synchronized (obj) {
				synchronized (obj2) {
					System.out.println("B����"+i);
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
