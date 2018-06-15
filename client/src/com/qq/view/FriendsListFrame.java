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
		setTitle("模拟QQ");
		
		ImageIcon portraItImage = new ImageIcon("src/images/logo.png");
		portraItImage.setImage(portraItImage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		JLabel portraItImageLable = new JLabel(portraItImage);
		JPanel centerPanel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		northPanel.add(portraItImageLable, BorderLayout.NORTH);
		JPanel userInfoPanel = new JPanel(new GridLayout(2, 2, 5, 10));
		
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		JLabel userInfoLable = new JLabel(hour < 6 ? "凌晨好，" : (hour < 12 ? "上午好，" : (hour < 18 ? "下午好，" : "晚上好，")) + userInfo.getNickname()+"("+userInfo.getUsername()+")");
		userInfoPanel.add(userInfoLable);
		
		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getInstance();
		simpleDateFormat.applyPattern("yyyy年MM月dd日  E");
		JLabel userTimeLable = new JLabel(simpleDateFormat.format(new Date()));
		userInfoPanel.add(userTimeLable);
		
		northPanel.add(userInfoPanel);
		//centerPanel.add(new JLabel("在线用户列表："), BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = getWidth();
		int screenWidth = screenSize.width / 2;
		setLocation(screenWidth - width / 2, 100);
		//setResizable(false);
		
		//创建选项卡
		JTabbedPane table = new JTabbedPane();
		JPanel contacts = new JPanel(new GridLayout());
		JPanel groupChat = new JPanel();
		table.add("联系人", contacts);
		table.addTab("群聊", groupChat);
		//JTree
		JPanel panel = new JPanel(new BorderLayout());
		contacts.add(panel);
		contacts.setLocation(5, 5);
        // 创建根节点
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("分组列表");

        List<Group> groups = userInfo.getGroupList();
        for (Group group : groups) {
        	DefaultMutableTreeNode g = new DefaultMutableTreeNode(group.getGroupName());
        	rootNode.add(g);
        	Map<String, String> friends = group.getFriendsMap();
        	for(Entry<String, String> name : friends.entrySet()) {
        		g.add(new DefaultMutableTreeNode(name.getValue()+"("+name.getKey()+")"));
        	}
		}

        // 使用根节点创建树组件
        tree = new JTree(rootNode);
        // 设置树不显示根节点句柄
        tree.setShowsRootHandles(false);
        // 设置根元素不显示
        tree.setRootVisible(false);
        // 设置树节点不可编辑
        tree.setEditable(false);
        // 设置节点选中监听器
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

        // 创建滚动面板，包裹树（因为树节点展开后可能需要很大的空间来显示，所以需要用一个滚动面板来包裹）
        JScrollPane scrollPane = new JScrollPane(tree);
        // 添加滚动面板到那内容面板
        panel.add(scrollPane);
        
        add(table);
	}
	
	/**
	 * @Title: createFriendRightKeyMenu  
	 * @Description: 创建好友列表的右键菜单
	 * @param @return    参数  
	 * @return JPopupMenu    返回类型
	 */
	private JPopupMenu createFriendRightKeyMenu() {
		JPopupMenu pop = new JPopupMenu();
		JMenuItem sendMessage = new JMenuItem("发送消息");
		JMenuItem rename = new JMenuItem("修改备注名");
		JMenuItem delete = new JMenuItem("删除好友");
		pop.add(sendMessage);
		pop.add(rename);
		pop.add(delete);
		
		/**
		 * 打开聊天窗口
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
		 * 重命名好友备注
		 */
		rename.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath selPath = tree.getSelectionPath();
				if(selPath != null) {
					tree.setSelectionPath(selPath);
					DefaultMutableTreeNode nodeName = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					String newNick = JOptionPane.showInputDialog(null, "请输入新的昵称！");
					if(newNick != null && !newNick.trim().equals("")) {
						String s = newNick+"("+nodeName.toString().split("[(]")[1];
						nodeName.setUserObject(s);
						connection.send("*#UPDATE_NICK#*-" + s);
					}
				}
			}
		});
		
		/**
		 * 删除好友
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
	 * @Description: 创建分组的右键菜单
	 * @param @return    参数  
	 * @return JPopupMenu    返回类型
	 */
	private JPopupMenu createGroupRightKeyMenu() {
		JPopupMenu pop = new JPopupMenu();
		JMenuItem add = new JMenuItem("添加分组");
		JMenuItem rename = new JMenuItem("重命名");
		JMenuItem delete = new JMenuItem("删除分组");
		pop.add(add);
		pop.add(rename);
		pop.add(delete);
		
		/**
		 * 添加分组
		 */
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		/**
		 * 重命名分组
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
		 * 删除分组
		 */
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return pop;
	}

	private void addEventHandler() {
		//设置鼠标右键选中节点
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
		
		//设置鼠标双击打开聊天窗口
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
		 * 关闭窗口
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "确认要退出客户端吗？\n温馨提示：退出会同时关闭所有聊天窗口", "确认退出", JOptionPane.OK_CANCEL_OPTION);
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
