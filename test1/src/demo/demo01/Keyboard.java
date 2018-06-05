package demo.demo01;

public class Keyboard implements USB {
	public void open() {
		System.out.println("键盘启动了");
	}
	
	public void close() {
		System.out.println("键盘关闭了");
	}
}
