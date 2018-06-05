package gui;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 * @ClassName: Test7
 * @Description: 单选框和复选框
 * @author Administrator  
 * @date 2018年6月3日  
 *
 */
public class Test7 extends JFrame {
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg;
	
	public static void main(String[] args) {
		Test7 test7 = new Test7();
	}
	
	public Test7() {
		//创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jlb1 = new JLabel("你喜欢的运动");
		jlb2 = new JLabel("你的性别");
		jb1 = new JButton("注册用户");
		jb2 = new JButton("取消注册");
		jcb1 = new JCheckBox("足球");
		jcb2 = new JCheckBox("篮球");
		jcb3 = new JCheckBox("网球");
		jrb1 = new JRadioButton("男");
		jrb2 = new JRadioButton("女");
		
		//放入ButtonGroup
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//设置布局管理器
		this.setLayout(new GridLayout(3, 1));
		
		//加入组件
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//加入到JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//设置窗口属性
		this.setTitle("多种布局演示");
		this.setSize(300, 150);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//禁止用户改变窗口大小
		this.setResizable(false);
		
		//显示窗口
		this.setVisible(true);
	}
}
