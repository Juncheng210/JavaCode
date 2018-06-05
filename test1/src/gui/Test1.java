package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 extends JFrame {
	JButton jb1 = null;
	public static void main(String[] args) {
		Test1 test1 = new Test1();
	}
	
	public Test1() {
		jb1 = new JButton("按钮1");
		//设置标题
		this.setTitle("GUI测试");
		//设置大小
		this.setSize(400, 300);
		//添加JButton组件
		this.add(jb1);
		//设置起始位置
		this.setLocation(200, 300);
		//设置关闭窗口是退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置可见
		this.setVisible(true);
	}
}
