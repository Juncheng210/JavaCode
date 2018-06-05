package day0522;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:\\test\\test.txt");
			System.out.println(fis.read());
			System.out.println(fis.skip(3));
			System.out.println(fis.available());
			byte[] arr = new byte[5];
			fis.read(arr);
			System.out.println(Arrays.toString(arr));
			fis.close();
			
			FileOutputStream fos = new FileOutputStream("D:\\test\\test1.txt");
//			FileOutputStream fos = new FileOutputStream("D:\\test\\test1.txt", true);//׷��
//			fos.write('a');
			fos.write("\t\nJava����֮IO��".getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
