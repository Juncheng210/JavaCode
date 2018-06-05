package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSplitPane;

public class Test9 extends JFrame {
	JSplitPane jsp;
	JList<String> jlist;
	JLabel jl1;
	
	public static void main(String[] args) {
		Test9 test9 = new Test9();
	}
	
	public Test9() {
		//创建组件
		String[] words = {"boy","girl","bird"};
		jlist = new JList<String>(words);
		
		jl1 = new JLabel(new ImageIcon("src/gui/images/test.jpg"));
		//拆分窗格
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jlist, jl1);
		jsp.setOneTouchExpandable(true);
		//添加组件
		this.add(jsp);
		
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
