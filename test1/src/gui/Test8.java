package gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Test8 extends JFrame {
	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox<String> jcb1;
	JList<String> jlist;
	JScrollPane jsp;
	
	public static void main(String[] args) {
		Test8 test8 = new Test8();
	}
	
	public Test8() {
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jl1 = new JLabel("籍贯");
		jl2 = new JLabel("旅游地点");
		
		String[] jg = {"北京", "上海", "天津", "成都"};
		jcb1 = new JComboBox<String>(jg);
		
		String[] dd = {"九寨沟", "故宫", "长城", "天安门"};
		jlist = new JList<String>(dd);
		//设置显示的个数
		jlist.setVisibleRowCount(2);
		jsp = new JScrollPane(jlist);
		
		
		//设置布局
		this.setLayout(new GridLayout(3, 1));
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jcb1);
		
		jp2.add(jl1);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);
		
		//设置窗口属性
		this.setTitle("多种布局演示");
		this.setSize(300, 150);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//禁止用户改变窗口大小
		//this.setResizable(false);
		
		//显示窗口
		this.setVisible(true);
	}
}
