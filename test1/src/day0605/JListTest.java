package day0605;

import javax.swing.JFrame;
import javax.swing.JList;

public class JListTest {
	public static void main(String[] args) {
		JFrame jf = new JFrame("JList");
		jf.setSize(300, 600);
		jf.setLocationRelativeTo(null);
		String[] arr = {"����", "İ����", "������"};
		JList<String> list = new JList<String>(arr);
		jf.add(list);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
