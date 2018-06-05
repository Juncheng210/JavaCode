package day0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerDemoThread2 implements Runnable {
	public static List<Socket> listSocket = new ArrayList<Socket>();
	private Socket socket;
	
	InputStream is = null;
	OutputStream os = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	
	public ServerDemoThread2(Socket socket, List<Socket> listSocket) {
		this.socket = socket;
		ServerDemoThread2.listSocket = listSocket;
	}

	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			pw = new PrintWriter(os, true);
			
			String str = "";
			while(true) {
				str = br.readLine();
				if(str.equals("exit")) {
					listSocket.remove(this.socket);
					break;
				}
				String[] strs = str.split("--");
				String ip = strs[0];
				String content = strs[1];
				int i = 0;
				for( ; i<listSocket.size(); i++) {
					String address = listSocket.get(i).getInetAddress().getHostAddress();
					if(address.equals(ip)) {
						sendMessage(listSocket.get(i), content);
						break;
					}
				}
				if(i==listSocket.size()) {
					pw.println("对方没有上线");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @Title: sendMessage  
	 * @Description:服务器给客户端转发消息
	 * @param @param socket2
	 * @param @param content    参数  
	 * @return void    返回类型
	 */
	private void sendMessage(Socket socket2, String content) {
		try {
			OutputStream os = socket2.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
