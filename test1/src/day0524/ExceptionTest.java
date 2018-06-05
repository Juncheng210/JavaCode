package day0524;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest {
	public static void main(String[] args) {
		InputStreamReader isr = null;
		try {
			System.out.println(1/0);
			isr = new InputStreamReader(new FileInputStream("D:/test/test2.txt"));
			System.out.println((char)isr.read());
			
		} catch (FileNotFoundException e) {
			System.out.println("catch_1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("catch_2");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("catch_3");
			e.printStackTrace();
		} finally {
			System.out.println("finally中的语句");
			try {
				isr.close();
			} catch (Exception e) {
				System.out.println("finally中的catch");
				e.printStackTrace();
			}
		}
		System.out.println("try...catch外面的语句");
	}
}
