package day0601;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerDemo2 {
	public static void main(String[] args) {
		List<Socket> list = new ArrayList<Socket>();
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(8888);
			while(true) {
				Socket socket = server.accept();
				list.add(socket);
				new Thread(new ServerDemoThread2(socket, list)).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
