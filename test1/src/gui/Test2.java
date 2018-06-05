package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @ClassName: Test2  
 * @Description: BorderLayout演示
 * @author Administrator  
 * @date 2018年6月3日  
 *
 */
public class Test2 extends JFrame {
	JButton jb1,jb2,jb3,jb4,jb5;
	
	public static void main(String[] args) {
		Test2 test2 = new Test2();
	}
	
	public Test2() {
		//创建组件
		jb1 = new JButton("中部");
		jb2 = new JButton("北部");
		jb3 = new JButton("东部");
		jb4 = new JButton("南部");
		jb5 = new JButton("西部");
		
		//添加组件
		this.add(jb1, BorderLayout.CENTER);
		this.add(jb2, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.EAST);
		this.add(jb4, BorderLayout.SOUTH);
		this.add(jb5, BorderLayout.WEST);
		
		//设置窗口属性
		this.setTitle("边界布局演示");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显示窗口
		this.setVisible(true);
	}
}
