package day0522;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamCopy {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:/test/test.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("D:/test/test2.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] arr = new byte[1024];
			int len = 0;
			while((len=bis.read(arr)) != -1) {
				bos.write(arr, 0, len);
			}
			bis.close();
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
