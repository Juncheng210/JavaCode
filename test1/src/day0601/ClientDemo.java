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

public class ClientDemo {
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		PrintWriter pw = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			socket = new Socket("localhost", 8888);
			os = socket.getOutputStream();
			is = socket.getInputStream();
			pw = new PrintWriter(os, true);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("���������ݣ�");
				String str = sc.nextLine();
				pw.println(str);
				
				if(str.equals("exit")) {
					break;
				}
				
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
