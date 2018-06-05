/**
 * 这是客户端和服务器端保持通讯的线程
 */
package client;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConServerThread extends Thread {

	private Socket socket;

	public ClientConServerThread(Socket socket) {
		this.socket = socket;

	}

	public void run() {
		while (true) {
			// 不停的读取从服务器端发来的信息
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message m = (Message) ois.readObject();
				// System.out.println("读取到从服务器发来的消息"+m.getSender()+"给"+m.getGetter()+"内容"+m.getCon());

				if (m.getMesType().equals(MessageQqType.MESSAGE_COMM_MES)) {
					// 把从服务器得到的消息显示到该显示的界面
					Chat chat = ManageChat.getChat(m.getGetter() + "" + m.getSender());
					// 显示
					chat.showMessage(m);
				} else if (m.getMesType().equals(MessageQqType.MESSAGE_RET_ONLINE_FRIEND)) {
					System.out.println("客户端接受到" + m.getCon());
					String con = m.getCon();
					String friends[] = con.split(" ");
					String getter = m.getGetter();
					// 修改相应的好友列表
					FriendList friendList = ManageFriendList.getQqFriend(getter);

					// 更新好友列表
					if (friendList != null) {
						friendList.updateFriend(m);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket s) {
		this.socket = s;
	}
}
