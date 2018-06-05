package day0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo2 {
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		PrintWriter pw = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			socket = new Socket("127.0.0.1", 8888);
			os = socket.getOutputStream();
			is = socket.getInputStream();
			pw = new PrintWriter(os, true);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			Scanner sc = new Scanner(System.in);
			//�ͻ������ӾͰѴ˿ͻ��˵�socket���͸�������
//			pw.println(socket);
			while(true) {
				System.out.println("���������ݣ���ʽΪ���Է�IP��ַ--���ݣ�");
				String str = sc.nextLine();
				
				if(str.equals("exit")) {
					pw.println("exit");
					break;
				} else {
					pw.println(str);
				}
				
				//��ȡ�������ķ�����Ϣ
				String s = br.readLine();
				System.out.println(s);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}