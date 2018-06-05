package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class LoginListener extends MouseAdapter implements ActionListener {  
	  
    private JComboBox jco ;//用来获取账号的对象  
    private JPasswordField jpa;//用来获取密码的对象  
    private JFrame jf;  
      
    /** 
     * 构造方法 
     */  
    public LoginListener(JComboBox jco ,JPasswordField jpa,JFrame jf){  
        this.jco = jco;  
        this.jpa = jpa;  
        this.jf = jf;  
    }   
    public LoginListener(JFrame jf){  
        this.jf = jf;  
    }     
    public void mouseExited(MouseEvent e) {  
        jf.dispose();  
          
    } 
      
      
    /** 
     * 事件的处理方法 
     */  
    public void actionPerformed(ActionEvent e) {  
          
        //System.out.println("你点击了"+e.getActionCommand()+"按钮");  
        //获取输入的账号，同时将账号转换为字符串  
        String name = (String)jco.getSelectedItem();  
        //获取输入的密码，同时将字符数组转换为字符串  
        String pwd = new String(jpa.getPassword());  
          
        //判断输入的账号和密码是否正确  
        if(name.equals("123456789") && pwd.equals("123456789")){  
            //关闭jf窗体  
            jf.dispose();  
            //实例化一个简单画板的界面  
            JFrame jfn = new JFrame();  
            jfn.setSize(289, 677);  
            jfn.setDefaultCloseOperation(3);  
            jfn.setLocation(800,0);  
            jfn.setLayout(null);  
            ImageIcon image =  new ImageIcon("qqFrame.jpg");  
            JLabel jla = new JLabel( image);  
            jla.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
            //将标签添加到窗体的第二层面板上  
            jfn.getLayeredPane().add(jla,new Integer(Integer.MIN_VALUE));  
            //获取窗体的第一层板对象  
            JPanel contentPanel = (JPanel)jfn.getContentPane();  
            //设置第一层面板为透明  
            contentPanel.setOpaque(false);  
              
            //实例化一个退出按钮  
            JButton jbc = new JButton(new ImageIcon("close.jpg"));  
            jfn.add(jbc);  
            jbc.setBounds(250,0,39,20);  
            jbc.setBorderPainted(false);  
            jbc.setFocusPainted(false);  
            //监听退出按钮  
            LoginCloseListener log = new LoginCloseListener(jfn);  
            jbc.setActionCommand("Login_close");  
            jbc.addActionListener(log);  
              
            jfn.setUndecorated(true);  
            jfn.setVisible(true);  
        }else{//输入的账号和密码不正确  
            //弹出一个消息提示框对象  
//          JOptionPane.showMessageDialog(null, "你输入的账号和密码不匹配，请重新输入！");  
            jf.dispose();  
            JFrame jfn = new JFrame();  
            jfn.setSize(378, 293);//设置窗体的大小  
            jfn.setLocation(497, 242);  
            jfn.setUndecorated(true);  
            jfn.setResizable(true);//设置不能调整窗口大小  
            jfn.setVisible(true);  
              
            //实例化一个ImageIcon图标类的对象  
            ImageIcon image = new ImageIcon("false.jpg");  
            //实例化一个标签类的对象  
            JLabel back = new JLabel(image);   
            //设置标签显示的位置和大小  
            back.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
            //将标签添加到窗体的第二层面板上  
            jfn.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));  
            JPanel contentPanel = (JPanel)jfn.getContentPane();  
            //设置第一层面板为透明  
            contentPanel.setOpaque(false);  
            jfn.setLayout(null);  
              
            JButton jb = new JButton(new ImageIcon("btn_close_normal.jpg"));  
            jb.setBounds(340,0,39,20);  
            jb.setRolloverIcon(new ImageIcon("btn_close_highlight.png"));  
            jb.setPressedIcon(new ImageIcon("btn_close_down.png"));  
            jb.setBorderPainted(false);  
            jb.setFocusPainted(false);  
            jb.setToolTipText("关闭");  
            jfn.add(jb);  
            LoginCloseListener ac = new LoginCloseListener(jfn);  
            jb.addActionListener(ac);  
        }  
          
    }  
      
      
}  
