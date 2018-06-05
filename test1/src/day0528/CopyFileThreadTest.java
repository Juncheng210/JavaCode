package day0528;

public class CopyFileThreadTest {
	public static void main(String[] args) {
//		new Thread(new CopyFileThread(5, 1, "D:/test/a/a.jpg", "D:/test/b/b.jpg")).start();
//		new Thread(new CopyFileThread(5, 2, "D:/test/a/a.jpg", "D:/test/b/b.jpg")).start();
//		new Thread(new CopyFileThread(5, 3, "D:/test/a/a.jpg", "D:/test/b/b.jpg")).start();
//		new Thread(new CopyFileThread(5, 4, "D:/test/a/a.jpg", "D:/test/b/b.jpg")).start();
//		new Thread(new CopyFileThread(5, 5, "D:/test/a/a.jpg", "D:/test/b/b.jpg")).start();
		
		new Thread(new CopyFileThread(2, 1, "D:/test/a/a.jpg", "D:/test/b/b.jpg")).start();
		new Thread(new CopyFileThread(2, 2, "D:/test/a/a.jpg", "D:/test/b/b.jpg")).start();
	}
}
