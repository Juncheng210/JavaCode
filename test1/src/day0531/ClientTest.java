package day0531;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket client = null;
		BufferedOutputStream bos = null;
		try {
			client = new Socket("localhost", 7890);
			System.out.println("客户端启动");
			
			bos = new BufferedOutputStream(client.getOutputStream());
			System.out.print("请输入要发送的信息：");
			String str = sc.next();
			bos.write(str.getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
}
