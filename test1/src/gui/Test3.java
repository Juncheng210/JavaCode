package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @ClassName: Test3  
 * @Description: 流式布局 
 * @author Administrator  
 * @date 2018年6月3日  
 *
 */
public class Test3 extends JFrame {
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public static void main(String[] args) {
		Test3 test3 = new Test3();
	}
	
	public Test3() {
		//创建组件
		jb1 = new JButton("按钮1");
		jb2 = new JButton("按钮2");
		jb3 = new JButton("按钮3");
		jb4 = new JButton("按钮4");
		jb5 = new JButton("按钮5");
		jb6 = new JButton("按钮6");
		
		//添加组件
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		//设置布局管理器
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//设置窗口属性
		this.setTitle("流式布局演示");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//禁止用户改变窗口大小
		this.setResizable(false);
		
		//显示窗口
		this.setVisible(true);
	}
}
