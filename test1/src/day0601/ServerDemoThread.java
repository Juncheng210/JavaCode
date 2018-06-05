package day0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerDemoThread implements Runnable {
	private String name;
	private Socket socket;
	
	InputStream is = null;
	OutputStream os = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	
	public ServerDemoThread(String name, Socket socket) {
		this.name = name;
		this.socket = socket;
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
					break;
				}
				System.out.println(this.name+"��"+str);
				pw.println(str+"^_^");
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
}
