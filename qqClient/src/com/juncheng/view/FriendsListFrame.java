package com.juncheng.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.juncheng.stream.ServerClientConnectionStream;
import com.juncheng.user.UserInfo;
import com.juncheng.util.MyMap;

public class FriendsListFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JList<String> currentOnlineUserList;
	private JTree tree;
	private UserInfo userInfo;
	private ChatFrame chatFrame;
	private MyMap isOpenMap;
	private Map<String, String> userInfoMap;
	private Map<String, ChatFrame> chatRoomMap = new HashMap<String, ChatFrame>();
	private Socket socket;
	private ServerClientConnectionStream c2s;

	public FriendsListFrame(UserInfo userInfo, Socket socket, ServerClientConnectionStream c2s) {
		this.userInfo = userInfo;
		this.socket = socket;
		this.c2s = c2s;
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
		centerPanel.add(new JLabel("�����û��б���"), BorderLayout.CENTER);
		centerPanel.add(listScrollPane, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = getWidth();
		int screenWidth = screenSize.width / 2;
		setLocation(screenWidth - width / 2, 100);
		//setResizable(false);
		
		//����ѡ�
		JTabbedPane table = new JTabbedPane();
		JPanel contacts = new JPanel(new GridLayout());
		JPanel groupChat = new JPanel();
		table.add("��ϵ��", contacts);
		table.addTab("Ⱥ��", groupChat);
		//JTree
		JPanel panel = new JPanel(new BorderLayout());
		contacts.add(panel);
		contacts.setLocation(5, 5);
        // �������ڵ�
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("�����б�");

        // ���������ڵ�
        DefaultMutableTreeNode gdNode = new DefaultMutableTreeNode("�ҵĺ���");
        DefaultMutableTreeNode fjNode = new DefaultMutableTreeNode("İ����");
        DefaultMutableTreeNode shNode = new DefaultMutableTreeNode("������");

        // �Ѷ����ڵ���Ϊ�ӽڵ����ӵ����ڵ�
        rootNode.add(gdNode);
        rootNode.add(fjNode);
        rootNode.add(shNode);

        // ���������ڵ�
        DefaultMutableTreeNode gzNode = new DefaultMutableTreeNode("123");
        DefaultMutableTreeNode szNode = new DefaultMutableTreeNode("456");

        DefaultMutableTreeNode fzNode = new DefaultMutableTreeNode("����");
        DefaultMutableTreeNode xmNode = new DefaultMutableTreeNode("����");

        DefaultMutableTreeNode tbNode = new DefaultMutableTreeNode("����");

        // �������ڵ���Ϊ�ӽڵ����ӵ���Ӧ�Ķ����ڵ�
        gdNode.add(gzNode);
        gdNode.add(szNode);

        fjNode.add(fzNode);
        fjNode.add(xmNode);

        shNode.add(tbNode);
        // ʹ�ø��ڵ㴴�������
        tree = new JTree(rootNode);
        
        // ����������ʾ���ڵ���
        tree.setShowsRootHandles(false);
        // ���ø�Ԫ�ز���ʾ
        tree.setRootVisible(false);

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
        // ���ӹ�����嵽���������
        panel.add(scrollPane);
        
        add(table);
	}

	private void addEventHandler() {
		tree.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
				System.out.println("11111111111111");
		        //TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
		        if(selRow != -1) {
		        	System.out.println("22222222222222222");
		        	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		        	String account = selectedNode.getUserObject().toString();
		        	if(account != null) {
						if(e.getClickCount() == 2) {
							System.out.println("333333333333333333333");
							if(!chatRoomMap.containsKey(account)){
								UserInfo toUserInfo = new UserInfo(account);
								chatFrame = new ChatFrame(toUserInfo, userInfo, isOpenMap);
								chatFrame.showMe();
								chatRoomMap.put(account, chatFrame);
								isOpenMap.replace(account, true);
			            	 }
						}
		        	}
				}
			}
		});
		
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
					System.exit(0);
				}
			}
		});
	}

	public void showWindow() {
		setSize(340, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void openChatWindow() {
		
	}
}