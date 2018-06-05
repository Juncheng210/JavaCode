package demo.demo01;

public class Mic implements USB {

	@Override
	public void open() {
		System.out.println("麦克风启动了");
	}

	@Override
	public void close() {
		System.out.println("麦克风关闭了");
	}
	
}
