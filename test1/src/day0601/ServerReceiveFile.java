package day0601;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ServerReceiveFile {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		InputStream is = null;
		File update = null;
		FileOutputStream fos = null;
		try {
			server = new ServerSocket(8888);
			socket = server.accept();
			//读取客户端发送的文件
			is = socket.getInputStream();
			//确定接收文件的存储位置
			update = new File("D:/test/b");
			if(!update.exists()) {
				update.mkdirs();
			}
			
			//随机给文件命名
			Random rand = new Random();
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmss");
			String filename = dateformat.format(date) + rand.nextInt(10000)+".jpg";
			//创建字节输出流，将文件写入
			fos = new FileOutputStream(update+File.separator+filename);
			//读写字节数组
			int len = -1;
			byte[] buff = new byte[1024];
			while((len=is.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
			
			//通过客户端socket将接收信息返回给客户端
			socket.getOutputStream().write("上传成功".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
