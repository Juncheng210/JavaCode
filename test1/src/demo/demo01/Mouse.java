package demo.demo01;
/**
 * 自定义的鼠标类
 * 满足USB接口规范
 *实现USB接口，重写抽象方法
 */
public class Mouse implements USB {
	public void open() {
		System.out.println("鼠标启动了");
	}
	
	public void close() {
		System.out.println("鼠标关闭了");
	}
}
