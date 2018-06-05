package day0524;

public class MyThread1 extends Thread {

	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			System.out.println(this.getName()+"--"+i);
		}
	}
	
}
