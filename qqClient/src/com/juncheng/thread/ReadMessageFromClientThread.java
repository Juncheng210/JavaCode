package com.juncheng.thread;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.juncheng.stream.Client2ClientStream;
import com.juncheng.user.UserInfo;

public class ReadMessageFromClientThread implements Runnable {
	private Client2ClientStream userDataCS;
	private JTextArea chatTextArea;
	private UserInfo toUserInfo;
	private volatile boolean stop = false;

	public ReadMessageFromClientThread(Client2ClientStream userDataCS, JTextArea chatTextArea,
			UserInfo toUserInfo) {
		super();
		this.userDataCS = userDataCS;
		this.chatTextArea = chatTextArea;
		this.toUserInfo = toUserInfo;
	}

	@Override
	public void run() {
		while (!stop) {
			synchronized (this) {
				System.out.println("客户端--客户端读取消息线程已启动！");
				if (userDataCS != null) {
					String message = userDataCS.read();
					System.out.println(message);
					if ("%TEST%".equals(message)) {
						System.out.println("客户端中原IP：" + userDataCS.getHostAddress() + "原端口：" + userDataCS.getPort());
						userDataCS.setHostAddress(userDataCS.getUserReceivePacket().getAddress());
						userDataCS.setPort(userDataCS.getUserReceivePacket().getPort());
						System.out.println("客户端中现IP：" + userDataCS.getHostAddress() + "现在端口：" + userDataCS.getPort());
					} else if ("I_HAVE_EXIT_THE_WINDOW".equals(message)) {
//						try {
//							userDataCS.setHostAddress(InetAddress.getByName(toUserInfo.getRecenIP()));
//							userDataCS.setPort(toUserInfo.getRecentPort());
//						} catch (UnknownHostException e) {
//							e.printStackTrace();
//						}
					} else {
						String tString[] = message.split("-");
						System.out.println("客户端--客户端(IP:" + userDataCS.getHostAddress() + "端口(UDP)："
								+ userDataCS.getPort() + ")读取到消息:" + message);
						StringBuffer tMessage = new StringBuffer();
						tMessage.append(tString[0]);
						tMessage.append(tString[5]);
						chatTextArea.append(tMessage + "\n");
					}
				}
			}
		}
	}

	public void stopMe() {
		stop = true;
	}
}
