package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @ClassName: Test5
 * @Description: 多种布局管理器使用
 * @author Administrator  
 * @date 2018年6月3日  
 *
 */
public class Test5 extends JFrame {
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public static void main(String[] args) {
		Test5 test5 = new Test5();
	}
	
	public Test5() {
		//创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jb1 = new JButton("西瓜");
		jb2 = new JButton("苹果");
		jb3 = new JButton("荔枝");
		jb4 = new JButton("葡萄");
		jb5 = new JButton("桔子");
		jb6 = new JButton("香蕉");
		
		//添加JPanel
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		//把panel加入JFrame
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb6, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);
		
		//设置布局管理器
		
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
