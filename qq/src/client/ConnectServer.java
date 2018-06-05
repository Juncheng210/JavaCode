/**
 * 这个是客户端连服务器的后台
 */
package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectServer {

	public  Socket socket;
	//发送第一次请求
	public boolean sendLoginInfoToServer(Object o)
	{
		boolean b=false;
		try {
			socket=new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			
			Message ms=(Message)ois.readObject();
			//这里就是验证用户登录的地方
			if(ms.getMesType().equals("1"))
			{
				//创建一个该qq号和服务器端保持通讯连接的线程
				ClientConServerThread ccst=new ClientConServerThread(socket);
				//启东该线程
				ManageClientConServerThread.addClientConServerThread(((User)o).getUserId(), ccst);
				ccst.start();
				b=true;
			}else{
				//关闭
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
