package day0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) {
		ServerSocket server = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			server = new ServerSocket(7890);
			System.out.println("服务器启动");
			Socket s = server.accept();
			System.out.println("有客户端连接");
			
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			String str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
