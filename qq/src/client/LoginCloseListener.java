package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginCloseListener implements ActionListener {  
    private JButton jb;  
    private JFrame jf;  
      
    //���ع��췽��  
    public LoginCloseListener(JFrame jf){  
        this.jf = jf;  
    }  
    /** 
     * �¼������� 
     */  
    public void actionPerformed(ActionEvent e){  
        jf.dispose();  
          
    }  
  
}  
