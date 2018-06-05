package day0524;

public class ThreadTest {
	public static void main(String[] args) {
		MyThread1 mt1 = new MyThread1();
		MyThread2 mt2 = new MyThread2();
		MyThread1 mt3 = new MyThread1();
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
