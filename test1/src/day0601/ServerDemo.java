package day0601;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(8888);
			while(true) {
				Socket socket = server.accept();
				new Thread(new ServerDemoThread(socket.getInetAddress().getHostName(),socket)).start();
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
