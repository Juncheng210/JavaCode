/**
 * ����ǿͻ������������ĺ�̨
 */
package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectServer {

	public  Socket socket;
	//���͵�һ������
	public boolean sendLoginInfoToServer(Object o)
	{
		boolean b=false;
		try {
			socket=new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			
			Message ms=(Message)ois.readObject();
			//���������֤�û���¼�ĵط�
			if(ms.getMesType().equals("1"))
			{
				//����һ����qq�źͷ������˱���ͨѶ���ӵ��߳�
				ClientConServerThread ccst=new ClientConServerThread(socket);
				//�������߳�
				ManageClientConServerThread.addClientConServerThread(((User)o).getUserId(), ccst);
				ccst.start();
				b=true;
			}else{
				//�ر�
				socket.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
				
		}
		return b;
	}
	
	
	public void SendInfoToServer(Object o)
	{
		try {
			Socket s=new Socket("127.0.0.1", 9999);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
				
		}
	}
}
