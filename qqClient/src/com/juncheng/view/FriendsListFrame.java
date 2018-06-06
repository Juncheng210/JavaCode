package com.juncheng.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class FriendsListFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JList<String> currentOnlineUserList;

	public FriendsListFrame() {
		createFrame();
		addEventHandler();
		showMe();
	}

	private void createFrame() {
		setTitle("模仿QQ");
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
		JLabel userInfoLable = new JLabel(hour < 6 ? "凌晨好，" : (hour < 12 ? "上午好，" : (hour < 18 ? "下午好，" : "晚上好，")));
		userInfoPanel.add(userInfoLable);
		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getInstance();
		simpleDateFormat.applyPattern("yyyy年MM月dd日    E");
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
		setResizable(false);
		
		//JTree
		JPanel panel = new JPanel(new BorderLayout());

        // 创建根节点
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("好友列表");

        // 创建二级节点
        DefaultMutableTreeNode gdNode = new DefaultMutableTreeNode("我的好友");
        DefaultMutableTreeNode fjNode = new DefaultMutableTreeNode("陌生人");
        DefaultMutableTreeNode shNode = new DefaultMutableTreeNode("黑名单");

        // 把二级节点作为子节点添加到根节点
        rootNode.add(gdNode);
        rootNode.add(fjNode);
        rootNode.add(shNode);

        // 创建三级节点
        DefaultMutableTreeNode gzNode = new DefaultMutableTreeNode("张三");
        DefaultMutableTreeNode szNode = new DefaultMutableTreeNode("李四");

        DefaultMutableTreeNode fzNode = new DefaultMutableTreeNode("王五");
        DefaultMutableTreeNode xmNode = new DefaultMutableTreeNode("赵六");

        DefaultMutableTreeNode tbNode = new DefaultMutableTreeNode("孙七");

        // 把三级节点作为子节点添加到相应的二级节点
        gdNode.add(gzNode);
        gdNode.add(szNode);

        fjNode.add(fzNode);
        fjNode.add(xmNode);

        shNode.add(tbNode);
        // 使用根节点创建树组件
        JTree tree = new JTree(rootNode);

        // 设置树显示根节点句柄
        tree.setShowsRootHandles(true);

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
        
        add(panel, BorderLayout.CENTER);
        setVisible(true);
	}

	private void addEventHandler() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int t = JOptionPane.showConfirmDialog(null, "确认要退出客户端吗？\n温馨提示：退出会同时关闭所有聊天窗口", "确认退出", JOptionPane.OK_CANCEL_OPTION);
				if (t == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	public void showMe() {
		setSize(340, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FriendsListFrame();
	}
}
