package demo.demo01;

public class Mic implements USB {

	@Override
	public void open() {
		System.out.println("��˷�������");
	}

	@Override
	public void close() {
		System.out.println("��˷�ر���");
	}
	
}
