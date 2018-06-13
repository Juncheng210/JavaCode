package com.qq.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionStream {
	private Socket socket;
	private OutputStream os;
	private InputStream is;
	private BufferedReader reader;
	private PrintWriter writer;
	private ObjectOutputStream objectWriter;
	private ObjectInputStream objectReader;

	public ConnectionStream(Socket socket) {
		this.socket = socket;
		getStream();
	}

	private void getStream() {
		try {
			os = socket.getOutputStream();
			is = socket.getInputStream();
			objectWriter = new ObjectOutputStream(os);
			objectReader = new ObjectInputStream(is);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (socket != null) {
			try {
				writer.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void send(String message) {
		writer.println(message);
		writer.flush();
	}

	public String read() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendObject(Object obj) {
		try {
			objectWriter.writeObject(obj);
			objectWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object readObject() {
		try {
			return objectReader.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
