package day0528;

public class Child implements Runnable {
	private static Object obj = new Object();
	private static int num = 1;
	private String id;
	
	public Child(String id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (obj) {
				if(this.id.equals(num+"")) {
					System.out.println(this.id+"¡ª¡ª"+Child.num);
					num++;
					obj.notifyAll();
					break;
				} else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
