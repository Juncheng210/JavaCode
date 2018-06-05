/**
 * 这是服务器控制界面的，可以启动服务器，关闭服务器，可以管理和监控用户，可以强制用户下线
 */
package server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyServerFrame extends JFrame implements ActionListener{

	JPanel jp1;
	JButton jb1, jb2;
	public static void main(String[] args) {
		MyServerFrame ms=new MyServerFrame();
	}
	
	public MyServerFrame()
	{
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1)
		{
			new MyQqServer();
		}
	}
}
