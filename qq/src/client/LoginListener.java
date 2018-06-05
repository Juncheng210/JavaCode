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
	  
    private JComboBox jco ;//������ȡ�˺ŵĶ���  
    private JPasswordField jpa;//������ȡ����Ķ���  
    private JFrame jf;  
      
    /** 
     * ���췽�� 
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
     * �¼��Ĵ����� 
     */  
    public void actionPerformed(ActionEvent e) {  
          
        //System.out.println("������"+e.getActionCommand()+"��ť");  
        //��ȡ������˺ţ�ͬʱ���˺�ת��Ϊ�ַ���  
        String name = (String)jco.getSelectedItem();  
        //��ȡ��������룬ͬʱ���ַ�����ת��Ϊ�ַ���  
        String pwd = new String(jpa.getPassword());  
          
        //�ж�������˺ź������Ƿ���ȷ  
        if(name.equals("123456789") && pwd.equals("123456789")){  
            //�ر�jf����  
            jf.dispose();  
            //ʵ����һ���򵥻���Ľ���  
            JFrame jfn = new JFrame();  
            jfn.setSize(289, 677);  
            jfn.setDefaultCloseOperation(3);  
            jfn.setLocation(800,0);  
            jfn.setLayout(null);  
            ImageIcon image =  new ImageIcon("qqFrame.jpg");  
            JLabel jla = new JLabel( image);  
            jla.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
            //����ǩ��ӵ�����ĵڶ��������  
            jfn.getLayeredPane().add(jla,new Integer(Integer.MIN_VALUE));  
            //��ȡ����ĵ�һ������  
            JPanel contentPanel = (JPanel)jfn.getContentPane();  
            //���õ�һ�����Ϊ͸��  
            contentPanel.setOpaque(false);  
              
            //ʵ����һ���˳���ť  
            JButton jbc = new JButton(new ImageIcon("close.jpg"));  
            jfn.add(jbc);  
            jbc.setBounds(250,0,39,20);  
            jbc.setBorderPainted(false);  
            jbc.setFocusPainted(false);  
            //�����˳���ť  
            LoginCloseListener log = new LoginCloseListener(jfn);  
            jbc.setActionCommand("Login_close");  
            jbc.addActionListener(log);  
              
            jfn.setUndecorated(true);  
            jfn.setVisible(true);  
        }else{//������˺ź����벻��ȷ  
            //����һ����Ϣ��ʾ�����  
//          JOptionPane.showMessageDialog(null, "��������˺ź����벻ƥ�䣬���������룡");  
            jf.dispose();  
            JFrame jfn = new JFrame();  
            jfn.setSize(378, 293);//���ô���Ĵ�С  
            jfn.setLocation(497, 242);  
            jfn.setUndecorated(true);  
            jfn.setResizable(true);//���ò��ܵ������ڴ�С  
            jfn.setVisible(true);  
              
            //ʵ����һ��ImageIconͼ����Ķ���  
            ImageIcon image = new ImageIcon("false.jpg");  
            //ʵ����һ����ǩ��Ķ���  
            JLabel back = new JLabel(image);   
            //���ñ�ǩ��ʾ��λ�úʹ�С  
            back.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
            //����ǩ��ӵ�����ĵڶ��������  
            jfn.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));  
            JPanel contentPanel = (JPanel)jfn.getContentPane();  
            //���õ�һ�����Ϊ͸��  
            contentPanel.setOpaque(false);  
            jfn.setLayout(null);  
              
            JButton jb = new JButton(new ImageIcon("btn_close_normal.jpg"));  
            jb.setBounds(340,0,39,20);  
            jb.setRolloverIcon(new ImageIcon("btn_close_highlight.png"));  
            jb.setPressedIcon(new ImageIcon("btn_close_down.png"));  
            jb.setBorderPainted(false);  
            jb.setFocusPainted(false);  
            jb.setToolTipText("�ر�");  
            jfn.add(jb);  
            LoginCloseListener ac = new LoginCloseListener(jfn);  
            jb.addActionListener(ac);  
        }  
          
    }  
      
      
}  
