package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginCloseListener implements ActionListener {  
    private JButton jb;  
    private JFrame jf;  
      
    //重载构造方法  
    public LoginCloseListener(JFrame jf){  
        this.jf = jf;  
    }  
    /** 
     * 事件处理方法 
     */  
    public void actionPerformed(ActionEvent e){  
        jf.dispose();  
          
    }  
  
}  
