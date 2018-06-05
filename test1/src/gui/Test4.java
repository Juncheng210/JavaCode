package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @ClassName: Test4 
 * @Description: 网格布局
 * @author Administrator  
 * @date 2018年6月3日  
 *
 */
public class Test4 extends JFrame {
	int size = 9;
	JButton[] jbs = new JButton[size];
	
	public static void main(String[] args) {
		Test4 test4 = new Test4();
	}
	
	public Test4() {
		//创建组件
		for(int i=0; i<9; i++) {
			jbs[i] = new JButton(""+(i+1));
		}
		
		//添加组件
		for(int i=0; i<9; i++) {
			this.add(jbs[i]);
		}
		
		//设置布局管理器
		this.setLayout(new GridLayout(3, 3, 10, 10));
		
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
