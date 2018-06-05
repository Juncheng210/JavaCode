package day0522;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamCopy {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:/test/qq.exe");
			FileOutputStream fos = new FileOutputStream("D:/test/a/qq.exe", true);
			byte[] arr = new byte[1024*1024];
			int len = 0;
			while((len = fis.read(arr)) != -1) {
				fos.write(arr, 0, len);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
