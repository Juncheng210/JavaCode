/**
 * ����qq�����������ڼ����ȴ�ĳ��qq�ͻ���������
 */
package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyQqServer {
	public static void main(String[] args) {

	}

	public MyQqServer() {
		try {
			// ��9999�Ŷ˿ڼ���
			System.out.println("���Ƿ�������9999��������");
			ServerSocket ss = new ServerSocket(9999);
			// ����,�ȴ��ͻ��˵�����
			while (true) {
				Socket s = ss.accept();

				// ���տͻ��˷�������Ϣ
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User) ois.readObject();
				System.out.println("���������յ�id: " + u.getUserId() + "�����룺" + u.getPasswd());
				Message m = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				if (u.getPasswd().equals("123")) {
					// ����һ���ɹ��ĵ�¼��Ϣ
					m.setMesType("1");
					oos.writeObject(m);

					// ���ﵥ��һ���߳��ø��̣߳���ͻ��˱���ͨѶ
					SerConClientThread scct = new SerConClientThread(s);
					ManagerClientThread.addClientThread(u.getUserId(), scct);
					// ������ÿͻ���ͨѶ���߳�
					scct.start();

					// ��֪ͨ�����û�
					scct.notifyOther(u.getUserId());

				} else {
					m.setMesType("2");
					oos.writeObject(m);
					// �ر�����
					s.close();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
