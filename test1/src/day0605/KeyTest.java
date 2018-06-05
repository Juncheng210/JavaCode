package day0605;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KeyTest {
	public static void main(String[] args) {
		Frame f = new Frame("�����¼�����");
		f.setLayout(null);
		TextField tf = new TextField();
		tf.setBounds(100, 100, 150, 20);
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(e.getKeyCode()>=KeyEvent.VK_0 && e.getKeyCode()<=KeyEvent.VK_9 || e.getKeyCode()==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		f.setSize(400, 300);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		f.add(tf);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
