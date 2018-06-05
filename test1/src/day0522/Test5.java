package day0522;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test5 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:/test/test.txt");
			FileOutputStream fos = new FileOutputStream("D:/test/aaa.txt");
			byte[] arr = new byte[1024];
			int len = 0;
			fis.read();
			fis.skip(-1);
			
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
