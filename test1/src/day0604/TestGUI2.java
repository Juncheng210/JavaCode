package day0604;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

public class TestGUI2 {
	Frame frame;
	Button btn1,btn2;
	TextField user;
	
	
	public static void main(String[] args) {
		TestGUI2 test = new TestGUI2();
	}
	
	public TestGUI2() {
		frame = new Frame("QQ��¼");
		frame.setBounds(300, 300, 400, 250);
		frame.setIconImage(new ImageIcon("src/day0604/qq.png").getImage());
		
		btn1 = new Button("��¼");
		btn2 = new Button("ע��");
		
		
		frame.setLayout(new BorderLayout());
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
