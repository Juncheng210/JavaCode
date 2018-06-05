package demo.demo01;

public class Test {
	public static void main(String[] args) {
		//创建笔记本对象，调用笔记本功能
		Computer comp = new Computer();
		//计算机开机
		comp.openComputer();
		
		//使用鼠标
		comp.useUSB(new Mouse());
		//使用键盘
		comp.useUSB(new Keyboard());
		//使用麦克风
		comp.useUSB(new Mic());
		//卸载鼠标
		comp.uninstallUSB(new Mouse());
		//卸载键盘
		comp.uninstallUSB(new Keyboard());
		//卸载麦克风
		comp.uninstallUSB(new Mic());
		
		//计算机关机
		comp.closeComputer();
	}
}
