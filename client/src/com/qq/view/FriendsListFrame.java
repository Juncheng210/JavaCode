package com.qq.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.qq.stream.ConnectionStream;
import com.qq.user.Group;
import com.qq.user.UserInfo;

public class FriendsListFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTree tree;
	private UserInfo userInfo;
	private static String friendUsername;
	private Socket socket;
	private ConnectionStream connection;
	
	public FriendsListFrame(UserInfo userInfo, Socket socket, ConnectionStream connection) {
		this.userInfo = userInfo;
		this.socket = socket;
		this.connection = connection;
		createFrame();
		addEventHandler();
		showWindow();
	}
		
	private void createFrame() {
		setTitle("ģ��QQ");
		
		ImageIcon portraItImage = new ImageIcon("src/images/logo.png");
		portraItImage.setImage(portraItImage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		JLabel portraItImageLable = new JLabel(portraItImage);
		JPanel centerPanel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		northPanel.add(portraItImageLable, BorderLayout.NORTH);
		JPanel userInfoPanel = new JPanel(new GridLayout(2, 2, 5, 10));
		
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		JLabel userInfoLable = new JLabel(hour < 6 ? "�賿�ã�" : (hour < 12 ? "����ã�" : (hour < 18 ? "����ã�" : "���Ϻã�")) + userInfo.getNickname()+"("+userInfo.getUsername()+")");
		userInfoPanel.add(userInfoLable);
		
		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getInstance();
		simpleDateFormat.applyPattern("yyyy��MM��dd��  E");
		JLabel userTimeLable = new JLabel(simpleDateFormat.format(new Date()));
		userInfoPanel.add(userTimeLable);
		
		northPanel.add(userInfoPanel);
		//centerPanel.add(new JLabel("�����û��б�"), BorderLayout.CENTER);
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

        List<Group> groups = userInfo.getGroupList();
        for (Group group : groups) {
        	DefaultMutableTreeNode g = new DefaultMutableTreeNode(group.getGroupName());
        	rootNode.add(g);
        	Map<String, String> friends = group.getFriendsMap();
        	for(Entry<String, String> name : friends.entrySet()) {
        		g.add(new DefaultMutableTreeNode(name.getValue()+"("+name.getKey()+")"));
        	}
		}

        // ʹ�ø��ڵ㴴�������
        tree = new JTree(rootNode);
        // ����������ʾ���ڵ���
        tree.setShowsRootHandles(false);
        // ���ø�Ԫ�ز���ʾ
        tree.setRootVisible(false);
        // �������ڵ㲻�ɱ༭
        tree.setEditable(false);
        // ���ýڵ�ѡ�м�����
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if(((DefaultMutableTreeNode)tree.getLastSelectedPathComponent()).isLeaf()){
        			tree.setComponentPopupMenu(createFriendRightKeyMenu());
        		} else {
        			tree.setComponentPopupMenu(createGroupRightKeyMenu());
        		}
            }
        });

        // ����������壬����������Ϊ���ڵ�չ���������Ҫ�ܴ�Ŀռ�����ʾ��������Ҫ��һ�����������������
        JScrollPane scrollPane = new JScrollPane(tree);
        // ��ӹ�����嵽���������
        panel.add(scrollPane);
        
        add(table);
	}
	
	/**
	 * @Title: createFriendRightKeyMenu  
	 * @Description: ���������б���Ҽ��˵�
	 * @param @return    ����  
	 * @return JPopupMenu    ��������
	 */
	private JPopupMenu createFriendRightKeyMenu() {
		JPopupMenu pop = new JPopupMenu();
		JMenuItem sendMessage = new JMenuItem("������Ϣ");
		JMenuItem rename = new JMenuItem("�޸ı�ע��");
		JMenuItem delete = new JMenuItem("ɾ������");
		pop.add(sendMessage);
		pop.add(rename);
		pop.add(delete);
		
		/**
		 * �����촰��
		 */
		sendMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath selPath = tree.getSelectionPath();
				if(selPath != null) {
					openChatWindow(friendUsername);
				}
			}
		});
		
		/**
		 * ���������ѱ�ע
		 */
		rename.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath selPath = tree.getSelectionPath();
				if(selPath != null) {
					tree.setSelectionPath(selPath);
					DefaultMutableTreeNode nodeName = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					String newNick = JOptionPane.showInputDialog(null, "�������µ��ǳƣ�");
					if(newNick != null && !newNick.trim().equals("")) {
						String s = newNick+"("+nodeName.toString().split("[(]")[1];
						nodeName.setUserObject(s);
						connection.send("*#UPDATE_NICK#*-" + s);
					}
				}
			}
		});
		
		/**
		 * ɾ������
		 */
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return pop;
	}
	
	/**
	 * @Title: createGroupRightKeyMenu  
	 * @Description: ����������Ҽ��˵�
	 * @param @return    ����  
	 * @return JPopupMenu    ��������
	 */
	private JPopupMenu createGroupRightKeyMenu() {
		JPopupMenu pop = new JPopupMenu();
		JMenuItem add = new JMenuItem("��ӷ���");
		JMenuItem rename = new JMenuItem("������");
		JMenuItem delete = new JMenuItem("ɾ������");
		pop.add(add);
		pop.add(rename);
		pop.add(delete);
		
		/**
		 * ��ӷ���
		 */
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		/**
		 * ����������
		 */
		rename.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath selPath = tree.getSelectionPath();
				if(selPath != null) {
					tree.startEditingAtPath(selPath);
				}
			}
		});
		
		/**
		 * ɾ������
		 */
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return pop;
	}

	private void addEventHandler() {
		//��������Ҽ�ѡ�нڵ�
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
				if(selPath != null) {
					DefaultMutableTreeNode nodeName = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					friendUsername = nodeName.getUserObject().toString();
					tree.setSelectionPath(selPath);
				}
			}
		});
		
		//�������˫�������촰��
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
		        if(selRow != -1) {
		        	if(e.getClickCount() == 2) {
		        		DefaultMutableTreeNode nodeName = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		        		if(nodeName.isLeaf()){
		        			friendUsername = nodeName.getUserObject().toString();
		        			openChatWindow(friendUsername);
		        		}
		        	}
				}
			}
		});
		
		/**
		 * �رմ���
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳��ͻ�����\n��ܰ��ʾ���˳���ͬʱ�ر��������촰��", "ȷ���˳�", JOptionPane.OK_CANCEL_OPTION);
				if(confirm == JOptionPane.OK_OPTION) {
					connection.send("*#EXIT#*");
					connection.close();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
	}

	public void showWindow() {
		setSize(340, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void openChatWindow(String friendUsername) {
		new ChatFrame(socket, userInfo, friendUsername, connection);
	}
}
