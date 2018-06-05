package day0528;
/**
 * 有三个类，里面都有打印方法，类A打印10个A，类B打印10个B，类C打印10个C，利用多线程实现轮流打印ABC
 */
public class Demo2 {
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		new Thread(new PrintA(a, b)).start();
		new Thread(new PrintB(b, c)).start();
		new Thread(new PrintC(c, a)).start();
	}
}
