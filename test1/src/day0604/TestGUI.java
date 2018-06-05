package day0604;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;

public class TestGUI {
	public static void main(String[] args) {
		Frame f = new Frame("GUIÑÝÊ¾");
		f.setBounds(200, 200, 300, 200);
		f.setIconImage(new ImageIcon("src/day0604/qq.png").getImage());
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		f.setVisible(true);
	}
}
