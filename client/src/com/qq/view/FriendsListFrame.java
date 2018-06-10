package com.qq.view;

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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

import com.qq.stream.ConnectionStream;
import com.qq.user.Group;
import com.qq.user.UserInfo;
import com.qq.util.MyMap;

public class FriendsListFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JList<String> currentOnlineUserList;
	private JTree tree;
	private UserInfo userInfo;
	//private ChatFrame chatFrame;
	private MyMap isOpenMap;
	private Map<String, String> userInfoMap;
	//private Map<String, ChatFrame> chatRoomMap = new HashMap<String, ChatFrame>();
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
		JLabel userInfoLable = new JLabel(hour < 6 ? "凌晨好，" : (hour < 12 ? "上午好，" : (hour < 18 ? "下午好，" : "晚上好，" +userInfo.getNickname())));
		userInfoPanel.add(userInfoLable);
		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getInstance();
		simpleDateFormat.applyPattern("yyyy年MM月dd日  E");
		JLabel userTimeLable = new JLabel(simpleDateFormat.format(new Date()));
		userInfoPanel.add(userTimeLable);
		northPanel.add(userInfoPanel);
		centerPanel.add(new JLabel("在线用户列表："), BorderLayout.CENTER);
		centerPanel.add(listScrollPane, BorderLayout.CENTER);
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
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("好友列表");

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

        // 设置树节点可编辑
        tree.setEditable(true);
        
        // 设置节点选中监听器
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("当前被选中的节点: " + e.getPath());
            }
        });

        // 创建滚动面板，包裹树（因为树节点展开后可能需要很大的空间来显示，所以需要用一个滚动面板来包裹）
        JScrollPane scrollPane = new JScrollPane(tree);
        // 添加滚动面板到那内容面板
        panel.add(scrollPane);
        
        add(table);
	}

	private void addEventHandler() {
		tree.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
		        //TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
		        if(selRow != -1) {
		        	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		        	String account = selectedNode.getUserObject().toString();
		        	if(account != null) {
						if(e.getClickCount() == 2) {
//							if(!chatRoomMap.containsKey(account)){
//								UserInfo toUserInfo = new UserInfo(account);
//								chatFrame = new ChatFrame(toUserInfo, userInfo, isOpenMap);
//								chatFrame.showMe();
//								chatRoomMap.put(account, chatFrame);
//								isOpenMap.replace(account, true);
//			            	 }
						}
		        	}
				}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int t = JOptionPane.showConfirmDialog(null, "确认要退出客户端吗？\n温馨提示：退出会同时关闭所有聊天窗口", "确认退出", JOptionPane.OK_CANCEL_OPTION);
				if(t == JOptionPane.OK_OPTION) {
					connection.send("*#EXIT#*");
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
