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
			//��ȡ�ͻ��˷��͵��ļ�
			is = socket.getInputStream();
			//ȷ�������ļ��Ĵ洢λ��
			update = new File("D:/test/b");
			if(!update.exists()) {
				update.mkdirs();
			}
			
			//������ļ�����
			Random rand = new Random();
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmss");
			String filename = dateformat.format(date) + rand.nextInt(10000)+".jpg";
			//�����ֽ�����������ļ�д��
			fos = new FileOutputStream(update+File.separator+filename);
			//��д�ֽ�����
			int len = -1;
			byte[] buff = new byte[1024];
			while((len=is.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
			
			//ͨ���ͻ���socket��������Ϣ���ظ��ͻ���
			socket.getOutputStream().write("�ϴ��ɹ�".getBytes());
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