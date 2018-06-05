/**
 * ���ǿͻ��˺ͷ������˱���ͨѶ���߳�
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
			// ��ͣ�Ķ�ȡ�ӷ������˷�������Ϣ
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message m = (Message) ois.readObject();
				// System.out.println("��ȡ���ӷ�������������Ϣ"+m.getSender()+"��"+m.getGetter()+"����"+m.getCon());

				if (m.getMesType().equals(MessageQqType.MESSAGE_COMM_MES)) {
					// �Ѵӷ������õ�����Ϣ��ʾ������ʾ�Ľ���
					Chat chat = ManageChat.getChat(m.getGetter() + "" + m.getSender());
					// ��ʾ
					chat.showMessage(m);
				} else if (m.getMesType().equals(MessageQqType.MESSAGE_RET_ONLINE_FRIEND)) {
					System.out.println("�ͻ��˽��ܵ�" + m.getCon());
					String con = m.getCon();
					String friends[] = con.split(" ");
					String getter = m.getGetter();
					// �޸���Ӧ�ĺ����б�
					FriendList friendList = ManageFriendList.getQqFriend(getter);

					// ���º����б�
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
