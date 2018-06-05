package day0524;

public class MyThread2 extends Thread {

	@Override
	public void run() {
		for(int i=100; i>=1; i--) {
			System.out.println(this.getName()+"--"+i);
		}
	}
	
}
