package day0521;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test2 {
	public static void main(String[] args) throws Exception {
		try {
			RandomAccessFile raf = new RandomAccessFile("D:\\test\\test1.txt", "rw");
//			raf.writeInt(123);
//			raf.writeInt(456);
//			raf.writeInt(789);
			raf.read();
			raf.seek(0);
//			System.out.println(raf.readInt());
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
	}
}
