package day0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTest2 {
	public static void main(String[] args) {
		Socket client = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			client = new Socket("localhost", 7890);
			isr = new InputStreamReader(client.getInputStream());
			br = new BufferedReader(isr);
			String str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
