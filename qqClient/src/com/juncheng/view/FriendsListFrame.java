package com.juncheng.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.juncheng.stream.ServerClientConnectionStream;
import com.juncheng.user.UserInfo;

public class FriendsListFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JList<String> currentOnlineUserList;
	private UserInfo userInfo;
	private Socket socket;
	private ServerClientConnectionStream c2s;

	public FriendsListFrame(UserInfo userInfo, Socket socket) {
		this.userInfo = userInfo;
		this.socket = socket;
		createFrame();
		addEventHandler();
		showWindow();
	}

	private void createFrame() {
		setTitle("ģ��QQ");
		currentOnlineUserList = new JList<String>();
		currentOnlineUserList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ImageIcon portraItImage = new ImageIcon("src/images/logo.png");
		portraItImage.setImage(portraItImage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		JLabel portraItImageLable = new JLabel(portraItImage);
		JScrollPane listScrollPane = new JScrollPane(currentOnlineUserList);
		JPanel centerPanel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		northPanel.add(portraItImageLable, BorderLayout.NORTH);
		JPanel userInfoPanel = new JPanel(new GridLayout(2, 2, 5, 10));
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		JLabel userInfoLable = new JLabel(hour < 6 ? "�賿�ã�" : (hour < 12 ? "����ã�" : (hour < 18 ? "����ã�" : "���Ϻã�" +userInfo.getName())));
		userInfoPanel.add(userInfoLable);
		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getInstance();
		simpleDateFormat.applyPattern("yyyy��MM��dd��  E");
		JLabel userTimeLable = new JLabel(simpleDateFormat.format(new Date()));
		userInfoPanel.add(userTimeLable);
		northPanel.add(userInfoPanel);
		centerPanel.add(new JLabel("�����û��б�"), BorderLayout.CENTER);
		centerPanel.add(listScrollPane, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = getWidth();
		int screenWidth = screenSize.width / 2;
		setLocation(screenWidth - width / 2, 100);
		setResizable(false);
		
		//JTree
		JPanel panel = new JPanel(new BorderLayout());

        // �������ڵ�
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("�����б�");

        // ���������ڵ�
        DefaultMutableTreeNode gdNode = new DefaultMutableTreeNode("�ҵĺ���");
        DefaultMutableTreeNode fjNode = new DefaultMutableTreeNode("İ����");
        DefaultMutableTreeNode shNode = new DefaultMutableTreeNode("������");

        // �Ѷ����ڵ���Ϊ�ӽڵ���ӵ����ڵ�
        rootNode.add(gdNode);
        rootNode.add(fjNode);
        rootNode.add(shNode);

        // ���������ڵ�
        DefaultMutableTreeNode gzNode = new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode szNode = new DefaultMutableTreeNode("����");

        DefaultMutableTreeNode fzNode = new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode xmNode = new DefaultMutableTreeNode("����");

        DefaultMutableTreeNode tbNode = new DefaultMutableTreeNode("����");

        // �������ڵ���Ϊ�ӽڵ���ӵ���Ӧ�Ķ����ڵ�
        gdNode.add(gzNode);
        gdNode.add(szNode);

        fjNode.add(fzNode);
        fjNode.add(xmNode);

        shNode.add(tbNode);
        // ʹ�ø��ڵ㴴�������
        JTree tree = new JTree(rootNode);

        // ��������ʾ���ڵ���
        tree.setShowsRootHandles(true);

        // �������ڵ�ɱ༭
        tree.setEditable(true);

        // ���ýڵ�ѡ�м�����
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("��ǰ��ѡ�еĽڵ�: " + e.getPath());
            }
        });

        // ����������壬����������Ϊ���ڵ�չ���������Ҫ�ܴ�Ŀռ�����ʾ��������Ҫ��һ�����������������
        JScrollPane scrollPane = new JScrollPane(tree);

        // ��ӹ�����嵽���������
        panel.add(scrollPane);
        
        add(panel, BorderLayout.CENTER);
	}

	private void addEventHandler() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int t = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳��ͻ�����\n��ܰ��ʾ���˳���ͬʱ�ر��������촰��", "ȷ���˳�", JOptionPane.OK_CANCEL_OPTION);
				if(t == JOptionPane.OK_OPTION) {
					c2s.send("*#EXIT#*");
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					FriendsListFrame.this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		});
	}

	public void showWindow() {
		setSize(340, 600);
		setVisible(true);
	}
}
