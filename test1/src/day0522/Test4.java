package day0522;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test4 {
	public static void main(String[] args) {
//		getFISTime();//文件字节流
		getBISTime();//缓冲字节流
	}
	public static void getFISTime() {
		try {
			long time1 = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream("C:/test/a/aaa.rar");
			FileOutputStream fos = new FileOutputStream("C:/test/a/aaa_1.rar");
			byte[] arr = new byte[1024];
			int len = 0;
			while((len = fis.read(arr)) != -1) {
				fos.write(arr, 0, len);
			}
			fis.close();
			fos.close();
			long time2 = System.currentTimeMillis();
			System.out.println(time2-time1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void getBISTime() {
		try {
			long time1 = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream("C:/test/b/aaa.rar");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("C:/test/b/aaa_1.rar");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] arr = new byte[1024];
			int len = 0;
			while((len = bis.read(arr)) != -1) {
				bos.write(arr, 0, len);
			}
			bis.close();
			bos.close();
			long time2 = System.currentTimeMillis();;
			System.out.println(time2-time1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
